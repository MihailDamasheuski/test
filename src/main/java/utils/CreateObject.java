package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import types.MessageType;

public interface CreateObject {

    JsonObject getStructureBody(MessageType type);

    JsonObject fillMessageBody(MessageType type);

    JsonObject addField(JsonObject object);

    JsonObject addField(String name, Object value);

    JsonObject addField(String name, JsonElement element);

}
