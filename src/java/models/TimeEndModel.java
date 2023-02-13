package models;

public class TimeEndModel {
    private String racerAbr;
    private String endTime;
    private String endDate;

    public String getAbbreviation() {return racerAbr;}
    public void setAbbreviation(String abr) {this.racerAbr = abr;}
    public String getEndTime() {return endTime;}
    public void setEndTime(String time) {this.endTime= time;}
    public String getEndDate() {return endDate;}
    public void setEndDate(String date) {this.endDate = date;}

    @Override
    public String toString() {
        return "\n End Time{" +
                "Racer abbreviation ='" + racerAbr + "'" +
                ", End time ='" + endTime + "'" + "}";
    }
}
