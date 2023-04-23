import com.google.gson.Gson;
import model.OpenWeatherApiResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Utilities {

    private static Gson GSON = new Gson();

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
}
