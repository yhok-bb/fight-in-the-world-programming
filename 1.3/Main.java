import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String encoded = "Mr John Smith ";
        int len = 13;
        StringBuilder replaced = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = encoded.charAt(i);
            if (c == ' ') {
                replaced.append("%20");
            } else {
                replaced.append(c);
            }
        }
        System.out.println(replaced);
    }
}
