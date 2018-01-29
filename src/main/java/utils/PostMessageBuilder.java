package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import types.MessageType;

public class PostMessageBuilder implements CreateObject {

    @Override
    public JsonObject getStructureBody(MessageType type) {
        return null;
    }

    @Override
    public JsonObject fillMessageBody(MessageType type) {
        return null;
    }

    @Override
    public JsonObject addField(JsonObject object) {
        return null;
    }

    @Override
    public JsonObject addField(String name, Object value) {
        return null;
    }

    @Override
    public JsonObject addField(String name, JsonElement element) {
        return null;
    }
}
