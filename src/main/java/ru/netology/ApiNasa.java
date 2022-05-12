package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiNasa {
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public ApiNasa(@JsonProperty("date") String date, @JsonProperty("explanation") String explanation,
                   @JsonProperty("hdurl") String hdurl, @JsonProperty("media_type") String media_type,
                   @JsonProperty("service_version") String service_version, @JsonProperty("title") String title,
                   @JsonProperty("url") String url) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
}