package models;

public class ResultModel {
    private String racerAbr;
    private String racerName;
    private String racerTeam;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

    public String getRacerAbbreviation() {
        return racerAbr;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

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




}
