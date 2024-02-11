package restassured.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import pl.bamnwa.properties.EnvironmentConfiguration;

public class TestBase {
    @BeforeClass
    public void setUp(){
        EnvironmentConfiguration environmentConfiguration = ConfigFactory.create(EnvironmentConfiguration.class);
        RestAssured.baseURI = environmentConfiguration.baseUri();
        RestAssured.basePath = environmentConfiguration.basePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }
}
