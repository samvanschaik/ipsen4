package nl.hsleiden;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import nl.hsleiden.mongoDatabase.MongoFactory;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Peter van Vliet
 */
public class ApiConfiguration extends Configuration implements AssetsBundleConfiguration
{
    @NotEmpty
    @JsonProperty
    private String apiName;

    private MongoFactory mongoFactory = new MongoFactory();

    @JsonProperty("mongoDB")
    public MongoFactory getMongoFactory() {
        return this.mongoFactory;
    }

    @JsonProperty("mongoDB")
    public void setMongoFactory(MongoFactory mongoFactory) {
        this.mongoFactory = mongoFactory;
    }


    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();
    
    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration()
    {
        return assets;
    }
}
