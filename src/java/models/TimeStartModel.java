package models;

public class TimeStartModel {
    private String racerAbr;
    private String startTime;
    private String startDate;
    public String getAbbreviation() {
        return racerAbr;
    }
    public void setAbbreviation(String abr) {
        this.racerAbr = abr;
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

    @Override
    public String toString() {
        return "\n Start Time{" +
                "Racer abbreviation ='" + racerAbr + "'" +
                ", Start time ='" + startTime + "'";
    }
}
