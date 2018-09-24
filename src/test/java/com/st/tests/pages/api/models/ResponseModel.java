package com.st.tests.pages.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;


import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    @Getter
    List<Colors> colors;
    @Getter
    List<Hues> hues;


    @Data
    public class Colors {
        String colorSpaceId;
        String sensation;
        String hue;
        String name;
        String colorId;
        String uriFriendlyName;
        String rgb;
        String collection;
    }

    @Data
    public class Hues {
        String hue;
        String name;
        String color;
        String mutedName;
        String mutedRgb;
        String rgb;
    }

}
