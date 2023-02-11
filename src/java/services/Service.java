package services;

import models.RacerModel;
import dao.DAO;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private int i =0;
    private List<ResultModel> setResultRacers() {
        List<RacerModel> racersList = new DAO().getRacersList();
        return racersList.stream()
                .map(str -> {
                    ResultModel racer = new ResultModel();
                    racer.setRacerAbbreviation(str.getRacerAbbreviation());
                    racer.setRacerName(str.getRacerName());
                    racer.setRacerTeam(str.getRacerTeam());
                    return racer;
                }).collect(Collectors.toList());
    }
    private List<ResultModel> fillInResultModel(){
        List<ResultModel> racers = new Service().setResultRacers();
        return racers.stream()
                .peek(str->{
                    str.setStartTime(combineRacerAndStartTime(str));
                    str.setEndTime(combineRacerAndEndTime(str));
                    str.setStartDate(combineRacerAndStartDate(str));
                    str.setEndDate(combineRacerAndEndDate(str));
                    str.setTimeStartResult(str.getStartTime(), str.getStartDate());
                    str.setTimeEndResult(str.getEndTime(), str.getEndDate());
                    str.setRaceResult();
        }).toList();
    }
    public List<ResultModel> getRaceFinishListLong(){
        List<ResultModel> racers = new Service().fillInResultModel();
        return racers.stream()
                .sorted(Comparator.comparingLong(ResultModel::getRaceResult))
                .peek(str->{
                    ++i;
                    str.setRacerNum(Integer.toString(i));
                })
                .toList();
    }
    private String combineRacerAndStartTime(ResultModel racerRes){
        List<TimeStartModel> timeStartList = new DAO().getStartTime();
        return timeStartList.stream().filter(t -> t.getAbbreviation().equals(racerRes.getRacerAbbreviation()))
                .findAny().orElse(null).getStartTime();
    }
    private String combineRacerAndEndTime(ResultModel racerRes){
        List<TimeEndModel> timeEndList = new DAO().getEndTime();
        return timeEndList.stream().filter(t -> t.getAbbreviation().equals(racerRes.getRacerAbbreviation()))
                .findAny().orElse(null).getEndTime();
    }
    private String combineRacerAndStartDate(ResultModel racerRes){
        List<TimeStartModel> dateStartList = new DAO().getStartTime();
        return dateStartList.stream().filter(t -> t.getAbbreviation().equals(racerRes.getRacerAbbreviation()))
                .findAny().orElse(null).getStartDate();
    }
    private String combineRacerAndEndDate(ResultModel racerRes){
        List<TimeEndModel> dateEndList = new DAO().getEndTime();
        return dateEndList.stream().filter(t -> t.getAbbreviation().equals(racerRes.getRacerAbbreviation()))
                .findAny().orElse(null).getEndDate();
    }
}
