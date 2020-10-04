package com.nomoko.task.data;

import java.io.Console;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import smile.interpolation.KrigingInterpolation;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    KrigingInterpolation interpolator;

    public DataService() throws CsvValidationException, IOException, URISyntaxException {

        final List<DataPoint> points = readFile("file.csv");
        final List<DataPoint> clean = cleanData(points);
        interpolator = loadData(clean);
    }

    List<DataPoint> readFile(final String file) throws IOException, URISyntaxException, CsvValidationException {
        final Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(file).toURI()));
        final List<DataPoint> list = new ArrayList<>();
        final CSVReader csvReader = new CSVReader(reader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            try {
                final DataPoint dp = parseLine(line);
                list.add(dp);
            } catch (final Exception e) {
                // log error
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

    List<DataPoint> cleanData(List<DataPoint> datapoints){

        //Group duplicate points
        HashMap<Point, List<Double>> hmap = new HashMap<Point, List<Double>>();
        datapoints.forEach( dp->{
            Point p = new Point(dp);
            var values = hmap.getOrDefault(p, new ArrayList<Double>());
            values.add(dp.getValue());
            hmap.put(p, values);
        });

        //Avg value at each position
        List<DataPoint> clean = new ArrayList<>();
        hmap.forEach((point,values) -> {
            Double val = values.stream().reduce(0.0, Double::sum) / values.size();
            DataPoint dp = new DataPoint(point, val);
            clean.add(dp);
        });

        return clean;
    }

    KrigingInterpolation loadData(List<DataPoint> datapoints){

        int datasize = datapoints.size();
        double[][] x = new double[datasize][2];
        double[] y = new double[datasize];
        int i = 0;

        for(DataPoint p : datapoints) {
            y[i] = p.getValue();
            x[i][0] = p.lat;
            x[i][1] = p.lon;
            i++;
        };

        KrigingInterpolation interpolator = new KrigingInterpolation(x,y);
        
        return interpolator;
    }

    public Double getValueAtPoint(final Point p) {
        return interpolator.interpolate(p.lat, p.lon);
        //return Double.valueOf(6.66);
    }
}