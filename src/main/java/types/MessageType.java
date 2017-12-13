package types;

import com.google.gson.JsonObject;

public interface MessageType {

    String getType();

    JsonObject getInitialObject();

}
