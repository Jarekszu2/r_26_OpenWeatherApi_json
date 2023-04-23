import model.OpenWeatherApiResponse;

public class Main {

    public static void main(String[] args) {

        Utilities utilities = new Utilities();

        System.out.println();

        String requestPresent = "http://api.openweathermap.org/data/2.5/weather?q=Elblag,pl&appid=5b0c78974922cbe51c892b9e213ad59e&mode=json&lang=pl&units=metric";
        System.out.println(requestPresent);

        System.out.println();
        String apiContent= utilities.loadApiContFromURL(requestPresent);
        System.out.println(apiContent);

        System.out.println();
        OpenWeatherApiResponse openWeatherApiResponse = utilities.get_OpenWeatherApiResponse_from_String_apiContent(apiContent);
        System.out.println(openWeatherApiResponse);

        System.out.println();
        System.out.println("Pogoda " + openWeatherApiResponse.getName() + ", "
                            + openWeatherApiResponse.getSys().getCountry()
                            + ": " + openWeatherApiResponse.getWeather()[0].getDescription()
                            + ", temperatura: " + openWeatherApiResponse.getMain().getFeels_like()
                            + ".");

    }
}
