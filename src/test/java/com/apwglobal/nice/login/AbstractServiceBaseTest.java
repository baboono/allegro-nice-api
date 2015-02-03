package com.apwglobal.nice.login;

import com.apwglobal.nice.service.Configuration;
import com.apwglobal.nice.util.VersionUtil;
import org.junit.BeforeClass;
import pl.allegro.webapi.ServicePort;
import pl.allegro.webapi.ServiceService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractServiceBaseTest {

    protected static ServicePort allegro = new ServiceService().getServicePort();
    protected static Credentials cred;
    protected static Configuration conf;

    @BeforeClass
    public static void abstractServiceSetup() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = AbstractServiceBaseTest.class.getResourceAsStream("/test-credentions.properties");
        properties.load(resourceAsStream);

        cred = new Credentials(
                properties.getProperty("alegro.username"),
                properties.getProperty("alegro.password"),
                properties.getProperty("alegro.key")
        );

        int countryId = Integer.valueOf(properties.getProperty("alegro.country"));
        long version = VersionUtil.getVersion(allegro, countryId, cred.getKey());
        conf = new Configuration(countryId, version);
    }

}