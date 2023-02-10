package controllers;

//import static services.Service.getRaceFinishListLong;

import services.Service;
import models.ResultModel;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        List<ResultModel> humanModelList = new Service().getRaceFinishListLong();
        System.out.println(humanModelList);
    }
}
