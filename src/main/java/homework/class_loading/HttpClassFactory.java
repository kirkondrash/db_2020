package homework.class_loading;

import homework.class_loading.http_classes.HttpClass;
import homework.class_loading.http_classes.HttpClassHandler;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpClassFactory {

    private static List<HttpClassHandler> httpClassImpls;

    static {
        /* it's really not that necessary for this task, just wanted to get to the hang of today's stuff.
        all the class hierarchy of httpclass classes was done to understand how inheriting would work here
        big enum with all handlers is not good; also, did not want to create additional maps.
        but these handlers may be even worse. For example, right now they are used in one instance, but
        they are not singletons (unfortunately, this pattern would look good with all these solutions) - and cannot be,
        given this architecture with extending and object initialising through reflection.
        Still, some incapsulation could be achieved if we give the client only HttpCodeService, which is ok I guess...
         */
        httpClassImpls = new ArrayList<>();

        String packageName = "homework.enums.http_classes.impl";
        URL root = HttpClassFactory.class.getResource("/"+packageName.replace(".","/"));
        // Filter .class files.
        File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));

        // Find classes extending HttpClass
        for (File file : files) {
            String className = file.getName().replaceAll(".class$", "");
            Class<?> cls;
            try {
                cls = Class.forName(packageName + "." + className);
                if (HttpClass.class.isAssignableFrom(cls)) {
                    httpClassImpls.add((HttpClassHandler)cls.getConstructor().newInstance());
                }
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static HttpClassHandler getHandler(String code){
        return httpClassImpls.stream().filter(handler -> handler.includesCode(code)).findFirst().get();
    }
}
