package nl.hsleiden.mongoDatabase;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.net.UnknownHostException;

public class MongoModule extends AbstractModule {

    private static final Logger logger = LoggerFactory.getLogger(MongoModule.class);

    private MongoClient mongoClient;
    private DB db;
    private MongoDatabase database;

    @Override
    protected void configure(){}

    @Provides
    @Named("mongodb")
    public Mongo provideMongo(MongoFactory factory) throws UnknownHostException {

        if (mongoClient == null) {
            mongoClient = factory.buildClient();
        }

        return mongoClient;
    }


    @Provides
    @Named
    public MongoDatabase provideDatabase(MongoFactory factory) throws UnknownHostException {

        if (database == null){
            logger.info("Building new Mongo DB instance with MongoFactory configuration = {}", factory);
            database = factory.buildMongoDatabase();
        }
        return database;
    }




}
