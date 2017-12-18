package parsing;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import services.TestDataFiles;
import services.TestDataProvider;

public class ParseApp {

    public static void main(String[] args) {
        TestDataProvider provider = new TestDataProvider();
        JsonObject object = provider.getObjectFromFile(TestDataFiles.VIDEO.getPath());
        JsonArray transcript = object.get("transcript").getAsJsonArray().get(1).getAsJsonArray();
        JsonArray markup = object.get("transcriptMarkup").getAsJsonArray().get(1).getAsJsonArray();
        TranscriptParser parser = new TranscriptParser(transcript, markup);
        JsonArray array = parser.proceedMarkup();
        array.forEach(System.out::println);
    }
}
