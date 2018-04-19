/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hsleiden;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import nl.hsleiden.mongoDatabase.MongoFactory;

/**
 *
 * @author Peter van Vliet
 */
public class ApiGuiceModule extends AbstractModule {



    @Override
    protected void configure()
    {
    }

    @Provides
    @Named("mongoFactory")
    public MongoFactory provideMongoFactory(ApiConfiguration configuration) {
        return configuration.getMongoFactory();
    }

}
