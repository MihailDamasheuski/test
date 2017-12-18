package parsing;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TranscriptParser {

    private String text;
    private JsonArray transcript;
    private JsonArray markup;

    public TranscriptParser(JsonArray transcript, JsonArray markup) {
        this.text = transcriptToSingleString(transcript);
        this.transcript = transcript;
        this.markup = markup;
    }

    private String transcriptToSingleString(JsonArray transcript) {
        StringBuilder builder = new StringBuilder();
        transcript.forEach(text -> builder.append(text.getAsString()));
        return builder.toString();
    }

    private int getPosition(JsonObject markupObject) {
        return markupObject.get("position").getAsInt();
    }

    private String getTextPart(int startChar, int endChar) {
        return this.text.substring(startChar, endChar);
    }

    private String getLiteral(JsonObject markupObject) {
        return markupObject.get("literal").getAsString();
    }

    public JsonArray proceedMarkup() {
        JsonArray result = new JsonArray();
        for (int i = 0; i < this.markup.size() - 1; i++) {
            int endChar = i != this.markup.size()
                    ? getPosition(this.markup.get(i + 1).getAsJsonObject())
                    : this.text.length();
            result.add(buildMarkupObject(getLiteral(this.markup.get(i).getAsJsonObject())
                    + getTextPart(getPosition(this.markup.get(i).getAsJsonObject()), endChar)));
        }
        return result.isJsonNull() ? null : result;
    }

    private JsonObject buildMarkupObject(String html) {
        JsonObject result = new JsonObject();
        result.addProperty("type", "markup");
        result.addProperty("linkObject", "false");
        result.addProperty("element", "p");
        result.addProperty("html", html);
        return result;
    }
}
