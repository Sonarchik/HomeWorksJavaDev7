import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";

    String getStatusImage(int code) {
        try {
            Jsoup.connect(BASE_URL + code).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            throw new IllegalArgumentException("There is not image for HTTP status " + code);
        }
        return BASE_URL + code;
    }
}
