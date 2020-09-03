package homework.enums;

import homework.enums.http_classes.HttpClassHandler;
import homework.enums.http_classes.impl.*;
import lombok.Getter;

import java.util.function.Supplier;
import java.util.regex.Pattern;

@Getter
public enum HttpClassCreator {
    INFORMATIONAL("1[0-9]{2}", Informational::new),
    SUCCESS("2[0-9]{2}", Success::new),
    REDIRECTION("3[0-9]{2}", Redirection::new),
    CLIENT_ERROR("4[0-9]{2}", ClientError::new),
    SERVER_ERROR("5[0-9]{2}", ServerError::new);

    private final Pattern patternExpression;
    private final Supplier<HttpClassHandler> handler;

    HttpClassCreator(String pattern, Supplier<HttpClassHandler> handler) {
        this.patternExpression = Pattern.compile(pattern);
        this.handler = handler;
    }

    public static HttpClassHandler handlerByHttpCode(String code) throws IllegalStateException{
        for (HttpClassCreator creator: HttpClassCreator.values()){
            if (creator.getPatternExpression().matcher(code).find()) {
                return creator.getHandler().get();
            }
        }
        throw new IllegalStateException(String.format("%s code handling is not supported", code));

    }
}
