package controllers;

import services.Service;
import models.ResultModel;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        List<ResultModel> raceAnalysisList = new Service().getRaceFinishListLong();
        System.out.println(raceAnalysisList);
    }
}
