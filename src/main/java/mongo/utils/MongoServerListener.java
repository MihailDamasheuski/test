package mongo.utils;

import com.mongodb.event.ServerClosedEvent;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.event.ServerListener;
import com.mongodb.event.ServerOpeningEvent;

public class MongoServerListener implements ServerListener {

    @Override
    public void serverOpening(ServerOpeningEvent serverOpeningEvent) {
        System.out.println("Opened connection to server with id: " + serverOpeningEvent.getServerId());
        System.out.println(serverOpeningEvent.toString());
    }

    @Override
    public void serverClosed(ServerClosedEvent serverClosedEvent) {
        System.out.println("Connection closed to server with id: " + serverClosedEvent.getServerId());
        System.out.println(serverClosedEvent.toString());
    }

    @Override
    public void serverDescriptionChanged(ServerDescriptionChangedEvent serverDescriptionChangedEvent) {
        System.out.println("Mongo server connection description" + serverDescriptionChangedEvent.toString());
    }
}
