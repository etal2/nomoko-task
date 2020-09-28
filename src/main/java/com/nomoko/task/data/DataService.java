package com.nomoko.task.data;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        interpolator = loadData(points);
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

    KrigingInterpolation loadData(List<DataPoint> datapoints){
        //TODO: need to cleanup data

        ArrayList<Double> yData = new ArrayList<>();
        ArrayList<Point> xData = new ArrayList<>();
        datapoints.forEach( p->{
            yData.add(p.getValue());
            xData.add(p);
        });

        double[][] x = new double[2][xData.size()];
        double[] y = new double[yData.size()];
        
        for(int i = 0; i < yData.size(); i++){
            y[i] = yData.get(i);
        }

        for(int i = 0; i <xData.size(); i++){
            Point p = xData.get(i);
            x[0][i] = p.lat;
            x[1][i] = p.lon;
        }

        //TODO: can't get this to work
        //KrigingInterpolation interpolator = new KrigingInterpolation(x,y);
        KrigingInterpolation interpolator = null;

        return interpolator;
    }

    public Double getValueAtPoint(final Point p) {
        //TODO: can't get this to work
        //return interpolator.interpolate(p.lat, p.lon);
        return Double.valueOf(6.66);
    }
}