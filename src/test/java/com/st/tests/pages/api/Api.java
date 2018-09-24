package com.st.tests.pages.api;


import com.st.tests.pages.api.models.ItemModel;
import com.taf.test.framework.helpers.ApiHelper;

import com.jayway.restassured.response.Response;

import java.util.List;


public class Api extends ApiHelper {

    public static final String PATH = "items/";

    public static Response getListOfColours(String endpoint) {
        return givenConfig().when().get(endpoint);
    }

    public static Response postDetails(List<ItemModel> itemModels) {


        return givenConfig().
                body(gson().toJson(itemModels)).
                when().
                post(PATH);
    }


    public static Response updateDetails(List<ItemModel> itemModels) {
        return givenConfig().
                body(gson().toJson(itemModels)).
                when().
                put(PATH);
    }


    public static Response deleteItem(String uniqueId) {
        return givenConfig().
                when().delete(PATH + uniqueId);
    }

}
