package nl.hsleiden.mongoDatabase;

import com.hubspot.dropwizard.guice.InjectableHealthCheck;
import com.mongodb.Mongo;

import javax.inject.Inject;


public class MongoHealthCheck extends InjectableHealthCheck {

    private final Mongo mongo;

    @Inject
    public MongoHealthCheck(Mongo mongo){
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }

    @Override
    public String getName() {
        return "mongo";
    }
}
