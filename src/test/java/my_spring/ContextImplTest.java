package my_spring;

import my_spring.system.Context;
import my_spring.system.ContextImpl;
import my_spring.system.configuration.Config;
import my_spring.system.configuration.impl.JavaConfig;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
public class ContextImplTest {

    @Test
    public void singletonAnnotationIsWorking() {

        Config config = Mockito.mock(Config.class);
        Mockito.when(config.getPackageToScan()).thenReturn("my_spring");

        Context context = new ContextImpl(config);

        Guy poorGuyOne = context.getObject(Guy.class);
        Guy poorGuyTwo = context.getObject(PoorGuy.class);
        Assert.assertEquals(poorGuyOne, poorGuyTwo);
    }
}























