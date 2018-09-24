package com.st.tests.pages.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ItemModel {

    String itemType;
    String uniqueId;
    String itemName;


}
