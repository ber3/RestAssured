package pl.bamnwa.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration.properties")
public interface EnvironmentConfiguration extends Config{
    @Key("BASE_URI")
    String baseUri();

    @Key("BASE_PATH")
    String basePath();
}