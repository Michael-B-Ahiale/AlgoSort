package com.abmike.algosort.api;

import com.abmike.algosort.model.SortResult;
import com.abmike.algosort.service.SortingService;
import com.abmike.algosort.util.HateoasUtil;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/sortresults/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class SortResultResource {

    private final SortingService sortingService = new SortingService();

    @GET
    public Response getSortResult(@PathParam("id") String id, @Context UriInfo uriInfo) {
        SortResult result = sortingService.getSortResult(id);
        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(HateoasUtil.addLinks(result, uriInfo)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSortResult(@PathParam("id") String id, SortResult updatedResult, @Context UriInfo uriInfo) {
        SortResult result = sortingService.updateSortResult(id, updatedResult);
        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(HateoasUtil.addLinks(result, uriInfo)).build();
    }

    @DELETE
    public Response deleteSortResult(@PathParam("id") String id) {
        boolean deleted = sortingService.deleteSortResult(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}