@Service
public class AlertService {
    
    @Autowired
    private RentaRepository rentaRepository;
    
    @Autowired
    private MailSender mailSender;
    
    @Scheduled(cron = "0 0 * * * *") // se ejecuta cada hora
    public void checkRentas() {
        List<Renta> rentas = rentaRepository.findAll();
        for (Renta renta : rentas) {
            if (renta.getFechaDevolucion() != null) {
                LocalDate fechaDevolucion = renta.getFechaDevolucion().toLocalDate();
                LocalDate hoy = LocalDate.now();
                long diasRestantes = ChronoUnit.DAYS.between(hoy, fechaDevolucion);
                if (diasRestantes <= 1) {
                    enviarAlerta(renta, diasRestantes);
                }
            }
        }
    }
    
    private void enviarAlerta(Renta renta, long diasRestantes) {
        // enviar correo electrónico al usuario
        String destinatario = renta.getUsuario().getEmail();
        String asunto = "Alerta: su renta está por expirar";
        String mensaje = "Su renta del libro " + renta.getLibro().getTitulo() +
                " está por expirar en " + diasRestantes + " día(s). " +
                "Por favor, devuelva el libro antes de la fecha de vencimiento.";
        mailSender.send(destinatario, asunto, mensaje);
    }
}