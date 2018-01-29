package mongo.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.event.ServerListener;
import mongo.utils.MongoServerListener;
import org.bson.Document;

import java.util.ArrayList;

public class MongoService {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCredential mongoCredential;
    private MongoClientOptions clientOptions;
    private ServerAddress serverAddress;
    private ServerListener serverListener;
    private String dataBaseName;
    private String userName;
    private String userPassword;
    private String dataBaseAddress;
    private String dataBasePort;
    private static final String ID_FIELD = "id";
    private static final long SECOND = 1000;
    private static final long WAIT_TIMEOUT = 10000;

    public MongoService(String dataBaseName, String userName, String userPassword, String dataBaseAddress, String dataBasePort) {
        this.dataBaseName = dataBaseName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.dataBaseAddress = dataBaseAddress;
        this.dataBasePort = dataBasePort;
        connectToMongo();
    }

    public MongoService(MongoClient mongoClient, MongoDatabase mongoDatabase) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = mongoDatabase;
        connectToMongo();
    }

    private MongoService() {
    }

    private void connectToMongo() {
        this.mongoCredential = MongoCredential.createCredential(userName, dataBaseName, userPassword.toCharArray());
        this.serverAddress = new ServerAddress(dataBaseAddress, Integer.parseInt(dataBasePort));
        this.serverListener = new MongoServerListener();
        this.clientOptions = MongoClientOptions.builder().addServerListener(serverListener).build();
        this.mongoClient = new MongoClient(serverAddress, mongoCredential, clientOptions);
        this.mongoDatabase = mongoClient.getDatabase(dataBaseName);
    }

    public boolean isRecordExist(String collectionName, String id) {
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        Document document = (Document) collection.find(Filters.eq(ID_FIELD, id)).first();
        return document != null;
    }

    public boolean waitForRecordInDB(String collectionName, String id) {
        long timeStamp = 0;
        boolean result = false;
        while (timeStamp != WAIT_TIMEOUT) {
            if (isRecordExist(collectionName, id)) {
                result = true;
            }
            try {
                Thread.sleep(SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeStamp += SECOND;
        }
        return result;
    }

    public JsonObject getObjectById(String collectionName, String id) {
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject query = new BasicDBObject();
        query.put(ID_FIELD, id);
        Document document = null;
        if (collectionExists(collectionName)) {
            document = (Document) collection.find(query).first();
            if (document == null) {
                System.out.println("No document with _id: " + id + " found in collection " + collectionName);
            }
        } else {
            System.out.println("No collection found with name " + collectionName);
        }
        return document != null ? documentToJsonObject(document) : null;
    }

    public boolean collectionExists(String collectionName) {
        return mongoDatabase.listCollectionNames()
                .into(new ArrayList<>()).contains(collectionName);
    }

    public void closeConnection() {
        this.mongoClient.close();
    }

    private JsonObject documentToJsonObject(Document document){
        return new JsonParser().parse(document.toJson()).getAsJsonObject();
    }
}

