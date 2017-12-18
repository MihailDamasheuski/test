//package context;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import services.TestDataProvider;
//import types.Image;
//import types.Post;
//
//@Configuration
//@ComponentScan
//public class ApplicationConfig {
//
//    @Bean(name = "testDataProviderBean")
//    @Scope("prototype")
//    public TestDataProvider testDataProvider(){
//        return new TestDataProvider();
//    }
//
//
//    @Bean(name = "imageBean")
//    @Scope("prototype")
//    public Image image(){
//        Image image = new Image(testDataProvider());
//        return image;
//    }
//
//    @Bean(name = "postBean")
//    public Post post(){
//        Post post = new Post(testDataProvider());
//        return post;
//    }
//
//}
