public class APIRickAndMorty { 
    // se crea una clase "APIRickAndMorty" para consumir el API y obtener la información de los personajes:
    private static final String BASE_URL = "https://rickandmortyapi.com/api";
    
    public List<Personaje> obtenerPersonajes(int pagina) throws IOException {
        String url = BASE_URL + "/character?page=" + pagina;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        JsonObject objetoJson = JsonParser.parseString(json).getAsJsonObject();
        JsonArray resultados = objetoJson.getAsJsonArray("results");
        List<Personaje> personajes = new ArrayList<>();
        for (JsonElement resultado : resultados) {
            JsonObject objetoResultado = resultado.getAsJsonObject();
            String nombre = objetoResultado.get("name").getAsString();
            String especie = objetoResultado.get("species").getAsString();
            String imagen = objetoResultado.get("image").getAsString();
            String estatus = objetoResultado.get("status").getAsString();
            Personaje personaje = new Personaje(nombre, especie, imagen, estatus);
            personajes.add(personaje);
        }
        return personajes;
    }
    
}
