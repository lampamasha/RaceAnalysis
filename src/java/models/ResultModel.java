package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ResultModel {
    private String racerAbr;
    private String racerName;
    private String racerTeam;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private LocalDateTime startData;
    private LocalDateTime endData;
    private long racerTimeDuration;
    private String numRacer;

    public void setRacerNum(String racerNum){this.numRacer = racerNum;}
    public String getRacerAbbreviation() {
        return racerAbr;
    }
    public String getRacerName() {
        return racerName;
    }
    public String getRacerTeam() {return racerTeam;}
    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbr = racerAbbreviation;
    }
    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }
    public void setRacerTeam(String racerTeam) {
        this.racerTeam = racerTeam;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String time) {
        this.startTime = time;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String date) {
        this.startDate = date;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String time) {
        this.endTime= time;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String date) {
        this.endDate = date;
    }
    public void setTimeStartResult(String startTime, String startDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
        String text = startDate + " " + startTime;
        this.startData = LocalDateTime.parse(text, formatter);
    }
    public void setTimeEndResult(String endTime, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
        String text = endDate + " " + endTime;
        this.endData = LocalDateTime.parse(text, formatter);
    }
    public void setRaceResult() {
        this.racerTimeDuration = Duration.between(this.startData, this.endData).toMillis();
    }
    public long getRaceResult() {
        return racerTimeDuration;
    }
    @Override
    public String toString() {
        if (numRacer.equals("16")){
            return '\n'+ "---------------------------------------------------------------"+
                    '\n'+numRacer + ". "+racerName + "   |" + racerTeam + "    |" +
                    String.format("%d:%d.%d",
                            TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration),
                            TimeUnit.MILLISECONDS.toSeconds(racerTimeDuration)-
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration)),
                            racerTimeDuration-
                                    TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration))-
                                    TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(racerTimeDuration)-
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration))));}
        else{
        return    '\n'+numRacer + ". "+racerName + "   |" + racerTeam + "    |" +
        String.format("%d:%d.%d",
                TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration),
                TimeUnit.MILLISECONDS.toSeconds(racerTimeDuration)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration)),
                racerTimeDuration-
                        TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration))-
                        TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(racerTimeDuration)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(racerTimeDuration))));}
    }
}
