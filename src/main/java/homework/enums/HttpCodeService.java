package homework.enums;

import homework.enums.http_classes.HttpClassHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {


    public static void processHttp(String text) {
        //todo dgasfdjgsafd  httpcode: 404   sjdghfkjdshgafsdah
        Pattern pattern = Pattern.compile("httpcode: ([0-9]{3})");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            HttpClassHandler handler = HttpClassFactory.getHandler(matcher.group(1));
            handler.work();
        }
    }

    public static void main(String[] args) {
        processHttp("todo dgasfdjgsafd  httpcode: 104   sjdghfkjdshgafsdah");
    }
}
