package com.nomoko.task;

import org.springframework.web.bind.annotation.RestController;

import com.nomoko.task.data.DataPoint;
import com.nomoko.task.data.DataService;
import com.nomoko.task.data.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("api")
public class ApiController {
    
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/property/value" )
	public DataPoint getPropertyValue(@RequestBody Point point) {

        DataPoint d = new DataPoint();
        d.setLat(point.getLat());
        d.setLon(point.getLon());
        d.setValue(dataService.getValueAtPoint(point));

		return d;
	}
}