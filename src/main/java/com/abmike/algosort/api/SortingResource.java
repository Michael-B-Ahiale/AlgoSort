package com.abmike.algosort.api;

import com.abmike.algosort.model.SortResult;
import com.abmike.algosort.service.SortingService;
import com.abmike.algosort.util.HateoasUtil;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/sort")
@Produces(MediaType.APPLICATION_JSON)
public class SortingResource {

    private static final Logger LOGGER = Logger.getLogger(SortingResource.class.getName());
    private final SortingService sortingService = new SortingService();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response sort(
            @FormParam("numbers") String numbers,
            @FormParam("algorithm") String algorithm,
            @Context UriInfo uriInfo
    ) {
        LOGGER.log(Level.INFO, "Sorting request received. Numbers: {0}, Algorithm: {1}", new Object[]{numbers, algorithm});

        try {
            SortResult result = sortingService.sort(numbers, algorithm);
            LOGGER.info("Sorting completed successfully");
            return Response.ok(HateoasUtil.addLinks(result, uriInfo)).build();
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Invalid input: {0}", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Invalid input: " + e.getMessage()))
                    .build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during sorting", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse("An unexpected error occurred"))
                    .build();
        }
    }

    @GET
    public Response getAllSortResults(@Context UriInfo uriInfo) {
        try {
            return Response.ok(HateoasUtil.addLinks(sortingService.getAllSortResults(), uriInfo)).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all sort results", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse("An unexpected error occurred"))
                    .build();
        }
    }


    private static class ErrorResponse {
        public String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }
}