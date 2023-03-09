public class ControladorPersonajes { 
    // se crea una clase "ControladorPersonajes" para manejar las peticiones del usuario y mostrar la lista y el detalle de los personajes
    private static final int PERSONAJES_POR_PAGINA = 20;
    
    @GetMapping("/personajes")
    public String mostrarLista(Model modelo, @RequestParam(defaultValue = "1") int pagina) {
        try {
            APIRickAndMorty api = new APIRickAndMorty();
            List<Personaje> personajes = api.obtenerPersonajes(pagina);
            int cantidadPaginas = api.obtenerCantidadPaginas(PERSONAJES_POR_PAGINA);
            modelo.addAttribute("personajes", personajes);
            modelo.addAttribute("cantidadPaginas", cantidadPaginas);
            modelo.addAttribute("paginaActual", pagina);
            return "listaPersonajes";
        } catch (IOException ex) {
            return "error";
        }
    }
    
    @GetMapping("/personajes/{id}")
    public String mostrarDetalle(Model modelo, @PathVariable int id) {
        try {
            APIRickAndMorty api = new APIRickAndMorty();
            Personaje personaje = api.obtenerDetallePersonaje(id);
            modelo.addAttribute("personaje", personaje);
            return "detallePersonaje";
        } catch (IOException ex) {
            return "error";
        }
    }
}
