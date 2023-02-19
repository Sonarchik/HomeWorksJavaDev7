import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus() {
        System.out.println("Enter HTTP status code");
        Scanner scan = new Scanner(System.in);
        int code;
        String sCode;

        while (true) {
            sCode = scan.nextLine();

            if (!sCode.matches("\\d{3}"))
                System.out.println("Please enter valid number");
            else break;
        }
        code = Integer.parseInt(sCode);
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        httpStatusImageDownloader.downloadStatusImage(code);
    }
}
