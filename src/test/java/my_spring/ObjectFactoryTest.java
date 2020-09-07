package my_spring;

import my_spring.system.configuration.impl.JavaConfig;
import my_spring.system.object_resolvers.impl.DynamicObjectResolver;
import my_spring.system.ObjectFactory;
import my_spring.system.object_resolvers.ObjectResolver;
import my_spring.system.configuration.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void injectRandomIntForIncorrectValuesIsFailing() {
        ObjectResolver objectResolver = Mockito.mock(ObjectResolver.class);
        Mockito.when(objectResolver.resolveImpl(Developer.class)).then(invocation -> Developer.class);
        ObjectFactory objectFactory = ObjectFactory.getInstance(objectResolver);
        objectFactory.createObject(Developer.class);
    }

    @Test
    public void injectRandomIntIsWorking() {
        ObjectResolver objectResolver = Mockito.mock(ObjectResolver.class);
        Mockito.when(objectResolver.resolveImpl(Soldier.class)).then(invocation -> Soldier.class);
        ObjectFactory objectFactory = ObjectFactory.getInstance(objectResolver);
        Soldier soldier = objectFactory.createObject(Soldier.class);
        Assert.assertTrue(soldier.getPower() < 15 && soldier.getPower() > 7);
    }

}























