package tests;

import context.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected ApplicationContext context;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
}
