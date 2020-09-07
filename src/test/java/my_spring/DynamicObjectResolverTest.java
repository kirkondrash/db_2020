package my_spring;

import my_spring.system.ObjectFactory;
import my_spring.system.configuration.Config;
import my_spring.system.configuration.impl.JavaConfig;
import my_spring.system.object_resolvers.ObjectResolver;
import my_spring.system.object_resolvers.impl.DynamicObjectResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
public class DynamicObjectResolverTest {

    @Test
    public void objectWasResolvedFromConfiguredClass() {
        Config config = Mockito.mock(Config.class);
        Mockito.when(config.getImpl(SuperHero.class)).then(invocation -> Batman.class);
        ObjectResolver objectResolver = new DynamicObjectResolver(config);
        Class<? extends SuperHero> superHero = objectResolver.resolveImpl(SuperHero.class);
        Assert.assertEquals(Batman.class, superHero);
    }
}























