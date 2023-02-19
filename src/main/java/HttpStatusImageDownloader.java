import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {

        String url = new HttpStatusChecker().getStatusImage(code);
        try {
            URL urlImage = new URL(url);
            InputStream in = urlImage.openStream();
            OutputStream os = new FileOutputStream("image" + code + ".jpg");
            byte[] buffer = new byte[2048];
            int c = in.read(buffer);

            while (c > 0) {
                os.write(buffer, 0, c);
                c = in.read(buffer);
            }
            os.close();
            in.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("There is not image for HTTP status " + code);
        }
    }
}
