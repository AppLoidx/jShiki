package com.apploidxxx.jshiki.model;

import lombok.Data;

/**
 * @author Arthur Kupriyanov
 */
@Data
public class Anime {
    private Long id;
    private String name;
    private AnimeImage image;
    private String url;
    private String kind;
    private Double score;
    private String status;
    private int episodes;
    private int episodesAired;
    private String airedOn;
    private String releasedOn;
}
