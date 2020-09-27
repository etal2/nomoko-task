package com.nomoko.task.data;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    Dictionary<Point, Double> data = new Hashtable<>() ;

    public DataService() throws CsvValidationException, IOException, URISyntaxException {
        
        List<DataPoint> points = readFile("file.csv");
        for (DataPoint dataPoint : points) {
            data.put(dataPoint, dataPoint.getValue());
        }
    }

    List<DataPoint> readFile(final String file) throws IOException, URISyntaxException, CsvValidationException {
        final Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(file).toURI()));
        final List<DataPoint> list = new ArrayList<>();
        final CSVReader csvReader = new CSVReader(reader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            try {
                DataPoint dp = parseLine(line);
                list.add(dp);
            } catch (Exception e) {
                //log error
                System.out.printf("Error reading csv line %d", csvReader.getLinesRead());
            }
        }
        reader.close();
        csvReader.close();
        
        return list;
    }

    private final Pattern pattern = Pattern.compile("POINT\\(([\\d\\.]+)\\s([\\d\\.]+)\\)");

    DataPoint parseLine(final String[] line) {
        final DataPoint dp = new DataPoint();

        final Matcher matcher = pattern.matcher(line[0].trim());

        if (matcher.find()) {
            final Double lat = Double.parseDouble(matcher.group(1));
            dp.setLat(lat);

            final Double lon = Double.parseDouble(matcher.group(2));
            dp.setLon(lon);
        }

        final Double val = Double.parseDouble(line[1].trim());
        dp.setValue(val);

        return dp;
    }

    Double getValueAtPoint(Point p) {
        return data.get(p);
    }

}