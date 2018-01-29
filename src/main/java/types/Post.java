package types;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import services.TestDataProvider;

public class Post implements MessageType {

    private static final String type = TypeValues.POST.getType();

    @Autowired
    private TestDataProvider testDataProvider;

    public Post(TestDataProvider testDataProvider) {
        this.testDataProvider = testDataProvider;
    }

    public String getType() {
        return type;
    }

    public JsonObject getInitialObject() {
        return null;
    }

}
