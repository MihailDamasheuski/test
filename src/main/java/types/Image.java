package types;

import com.google.gson.JsonObject;
import services.TestDataFiles;
import services.TestDataProvider;

public class Image implements MessageType {

    private static final String type = TypeValues.IMAGE.getType();

    private TestDataProvider dataProvider;

    public Image(TestDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getType() {
        return type;
    }

    public JsonObject getInitialObject() {
        return dataProvider.getObjectFromFile(TestDataFiles.IMAGE.getPath());
    }
}
