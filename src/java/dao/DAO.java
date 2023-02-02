package dao;

import models.RacerModel;
import models.TimeStartModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DAO {
    private static InputStream readFile(String fileName){
        ClassLoader classLoader = DAO.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        return inputStream;
    }
    public static List<RacerModel> getRacersList() {
        List<RacerModel> racersList;
        try
                (InputStream inputStream = readFile("abbreviations.txt")){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            racersList =
                    bufferedReader.lines()
                            .map(line -> line.split("_"))
                            .map(str -> {
                                RacerModel racer = new RacerModel();
                                racer.setRacerAbbreviation(str[0]);
                                racer.setRacerName(str[1]);
                                racer.setRacerTeam(str[2]);
                                return racer;
                            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return racersList;
    }

    public static List<TimeStartModel> getStartTime() {
        List<TimeStartModel> listOfStartTime;
        try
                (InputStream inputStream = readFile("start.log")) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            listOfStartTime =
                    bufferedReader.lines()
                            .map(line -> line.split("_"))
                            .map(str -> {
                                TimeStartModel time = new TimeStartModel();
                                time.setAbbreviation(str[0].substring(0,3));
                                time.setStartTime(str[1]);
                                time.setStartDate(str[0].substring(3));
                                return time;
                            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfStartTime;
    }
}

