package com.nomoko.task.data;

import lombok.Data;

@Data
public class Point {
    Double lat;
    Double lon;

    public Point(){}
    
    public Point(Point p){
        this.setLat(p.getLat());
        this.setLon(p.getLon());
    }
}