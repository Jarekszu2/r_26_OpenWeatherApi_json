import com.google.gson.Gson;
import model.OpenWeatherApiResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Utilities {

    private final static Gson GSON = new Gson();

    private HttpClient client = HttpClient.newBuilder().build();

    public String loadApiContFromURL(String apiURL) {
        final StringBuilder stringBuilder = new StringBuilder();
        String apiContent = null;
        try {
            URL url = new URL(apiURL);
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))){
                bufferedReader.lines().forEach(stringBuilder::append);
                apiContent = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return apiContent;
    }

    public OpenWeatherApiResponse get_OpenWeatherApiResponse_from_String_apiContent(String apiContent){
        return GSON.fromJson(apiContent, OpenWeatherApiResponse.class);
    }

    public Optional<OpenWeatherApiResponse> getApiRespone(){    // Uwaga: zmienić w POM'ie javę na 11

        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://api.openweathermap.org/data/2.5/weather?q=Elblag,pl&appid=5b0c78974922cbe51c892b9e213ad59e&mode=json&lang=pl&units=metric"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return Optional.ofNullable(GSON.fromJson(response.body(), OpenWeatherApiResponse.class));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public String getAll(){

        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://api.openweathermap.org/data/2.5/weather?q=Elblag,pl&appid=5b0c78974922cbe51c892b9e213ad59e&mode=json&lang=pl&units=metric"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
//            return GSON.fromJson(response.body(), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "lipa...";
    }
}
