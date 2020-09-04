package homework.class_loading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {

    private HttpClassFactory httpClassFactory;

    public HttpCodeService() {
        httpClassFactory = new HttpClassFactory();
    }

    public void processHttp(String text) {
        //todo dgasfdjgsafd  httpcode: 404   sjdghfkjdshgafsdah
        Pattern pattern = Pattern.compile("httpcode: ([0-9]{3})");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            HttpClassHandler handler = httpClassFactory.getHandler(matcher.group(1));
            handler.work();
        }
    }

    public static void main(String[] args) {
        HttpCodeService httpCodeService = new HttpCodeService();
        httpCodeService.processHttp("todo dgasfdjgsafd  httpcode: 104   sjdghfkjdshgafsdah");
        httpCodeService.processHttp("todo dgasfdjgsafd  httpcode: 204   sjdghfkjdshgafsdah");
        httpCodeService.processHttp("todo dgasfdjgsafd  httpcode: 304   sjdghfkjdshgafsdah");
    }
}
