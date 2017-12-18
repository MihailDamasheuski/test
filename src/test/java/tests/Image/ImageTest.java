package tests.Image;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import types.Image;
import utils.json.utils.PathFields;


public class ImageTest extends BaseImageTest{

    @Autowired
    private Image image;

    @Test
    public void imageTest(){
        JsonObject imageObject = image.getInitialObject();
        Assert.assertTrue(imageObject.get(PathFields.ACTION.field()).isJsonPrimitive());
        System.out.println(image.getType());
    }
}
