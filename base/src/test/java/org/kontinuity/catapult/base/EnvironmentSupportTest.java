package org.kontinuity.catapult.base;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class EnvironmentSupportTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetEnvVarOrSysPropDefaultShouldNotBeNull() {
        EnvironmentSupport.INSTANCE.getEnvVarOrSysProp("foo",null);
    }

    @Test
    public void testGetEnvVarOrSysProp() {
        String pathSeparator = EnvironmentSupport.INSTANCE.getEnvVarOrSysProp("path.separator");
        Assert.assertEquals(File.pathSeparator, pathSeparator);
    }

    @Test
    public void testGetEnvVarOrSysPropDefault() {
        String pathSeparator = EnvironmentSupport.INSTANCE.getEnvVarOrSysProp("path.separator.foo",File.pathSeparator);
        Assert.assertEquals(File.pathSeparator, pathSeparator);
    }
}
