package se.vert.chuck.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChuckModel {

    private String[] category;

    @JsonProperty("icon_url")
    private String iconURL;

    private String id;

    private String url;

    private String value;
}
