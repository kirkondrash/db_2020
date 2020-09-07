package my_spring;

import my_spring.system.Context;
import my_spring.system.ContextImpl;
import my_spring.system.configuration.impl.JavaConfig;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {


        Map<Class<?>, Class<?>> map = Map.of(
                Speaker.class, ConsoleSpeaker.class
                );

        Context context = new ContextImpl(new JavaConfig(map,"my_spring"));

        IRobot iRobot = context.getObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
