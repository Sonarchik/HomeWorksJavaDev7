import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpStatusCheckerTest {
    private static final String VALID_URL_CODE_100 = "https://http.cat/100";
    private static final String VALID_URL_CODE_404 = "https://http.cat/404";
    private static final String VALID_URL_CODE_499 = "https://http.cat/499";

    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

    @Test
    public void testGetStatusImage(){
        Assertions.assertEquals(VALID_URL_CODE_100, httpStatusChecker.getStatusImage(100));
        Assertions.assertEquals(VALID_URL_CODE_404, httpStatusChecker.getStatusImage(404));
        Assertions.assertEquals(VALID_URL_CODE_499, httpStatusChecker.getStatusImage(499));
    }
    @Test
    public void testThatStatusCheckerException()  {
        int code10000 = 10000;
        Assertions.assertThrows(IllegalArgumentException.class, () -> httpStatusChecker
                .getStatusImage(code10000));
        int code487 = 487;
        Assertions.assertThrows(IllegalArgumentException.class, () -> httpStatusChecker
                .getStatusImage(code487));
    }
}
