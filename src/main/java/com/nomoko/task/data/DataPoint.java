package com.nomoko.task.data;

import lombok.Data;

@Data
public class DataPoint extends Point {
    Double value;

    public DataPoint(){}

    public DataPoint(DataPoint dp){
        super(dp);
        this.setValue(dp.getValue());
    }

    public DataPoint(Point p, Double val){
        super(p);
        this.setValue(val);
    }
}