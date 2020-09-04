package homework.class_loading;

import homework.class_loading.http_class_handler_creators.AbstractHttpClassHandlerCreator;
import homework.class_loading.http_class_handler_creators.HttpClassHandlerCreator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class HttpClassFactory {

    private Reflections scanner = new Reflections("homework.class_loading.http_class_handler_creators.impl");
    private List<HttpClassHandlerCreator> httpClassImpls = new ArrayList<>();

    @SneakyThrows
    public HttpClassFactory() {
        for (Class<? extends HttpClassHandlerCreator> httpClassCreator: scanner.getSubTypesOf(HttpClassHandlerCreator.class)){
            if (httpClassCreator != AbstractHttpClassHandlerCreator.class){
                /* I dunno what's happening, it includes abstract class from another package (not impl)
                into the search, seems like some chacing problem
                 */
                HttpClassHandlerCreator h = httpClassCreator.getConstructor().newInstance();
                httpClassImpls.add(h);
            }
        }
    }

    public HttpClassHandler getHandler(String code){
        return httpClassImpls
                .stream()
                .filter(handlerCreator -> handlerCreator.includesCode(code))
                .findFirst()
                .orElseThrow(()->new IllegalStateException(String.format("%s not supported", code)))
                .createHandler();
    }
}
