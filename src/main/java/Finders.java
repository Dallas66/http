import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finders {

    public static String csrfTokenFinder(String str) {

        String result = "";

        Pattern csrfTokenPattern = Pattern.compile("csrfToken\":\"[^\"]++");
        Matcher matcher = csrfTokenPattern.matcher(str);
        if (matcher.find()) {
            result = matcher.group().replaceAll("csrfToken\":\"", "");

        }
        return result;
    }


    public static String yandexUidFinder(String str) {

        String result = "";

        Pattern csrfTokenPattern = Pattern.compile("yandexuid=[^\"]++");
        Matcher matcher = csrfTokenPattern.matcher(str);
        if (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }
}
