import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateFinder {

    public String[] findCoordinate(String str) {
        String[] result = new String[2];
        Pattern pattern = Pattern.compile("coordinates\":\\[\\-?\\d+(\\.\\d+)?,\\s*\\-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            result = matcher.group().replaceAll("coordinates\":\\[", "").split(",");
        }
        return result;
    }

    public String correctCoordinate(String[] strMassive) {
        String temp = strMassive[0];
        strMassive[0] = strMassive[1];
        strMassive[1] = temp;

        return Arrays.toString(strMassive);
    }
}
