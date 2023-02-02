package models;

public class RacerModel {
    private String racerAbr;
    private String racerName;
    private String racerTeam;

    public RacerModel() {
    }

    public RacerModel (String racerAbbreviation, String racerName, String racerTeam) {
        this.racerAbr= racerAbbreviation;
        this.racerName = racerName;
        this.racerTeam = racerTeam;
    }

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

    @Override
    public String toString() {
        return "\n Racer{" +
                "racerAbbreviation = '" + racerAbr + "'" +
                ", racerName='" + racerName + "'" +
                ", racerTeam='" + racerTeam + "'" + "}";
    }

}
