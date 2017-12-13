package tests.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tests.BaseTest;
import types.Image;

public class BaseImageTest extends BaseTest {

    @Autowired
    @Qualifier("imageBean")
    protected Image image;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpImage(){
//        image = context.getBean(Image.class);
//    }

}
