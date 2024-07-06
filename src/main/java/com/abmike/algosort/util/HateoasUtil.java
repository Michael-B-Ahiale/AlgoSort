package com.abmike.algosort.util;

import com.abmike.algosort.model.SortResult;

import jakarta.ws.rs.core.UriInfo;
import java.util.List;

public class HateoasUtil {

    public static SortResult addLinks(SortResult result, UriInfo uriInfo) {
        String selfLink = uriInfo.getBaseUriBuilder()
                .path("sortresults")
                .path(result.getId())
                .build()
                .toString();
        result.addLink("self", selfLink);
        return result;
    }

    public static List<SortResult> addLinks(List<SortResult> results, UriInfo uriInfo) {
        for (SortResult result : results) {
            addLinks(result, uriInfo);
        }
        return results;
    }
}