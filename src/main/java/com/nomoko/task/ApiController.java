package com.nomoko.task;

import org.springframework.web.bind.annotation.RestController;

import com.nomoko.task.data.DataPoint;
import com.nomoko.task.data.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping("api")
public class ApiController {
    
    @Autowired
    DataService dataService;

    @RequestMapping("/property/value")
	public DataPoint getPropertyValue() {
        DataPoint d = new DataPoint();
        d.setLat(546565.565);
        d.setLon(21423523.565);
        d.setValue(554.67);
		return d;
	}
}