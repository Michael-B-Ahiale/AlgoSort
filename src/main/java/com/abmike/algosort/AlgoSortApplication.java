package com.abmike.algosort;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AlgoSortApplication extends ResourceConfig {
    public AlgoSortApplication() {
        // Register the package containing your resources
        packages("com.abmike.algosort.api");

        // Register Jackson for JSON processing
        register(JacksonFeature.class);

        // If you're using any custom providers or features, register them here
        // For example:
        // register(CustomExceptionMapper.class);
    }
}