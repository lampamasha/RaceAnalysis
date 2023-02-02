package services;

import models.RacerModel;
import dao.DAO;
import models.TimeStartModel;

import java.util.List;

import static dao.DAO.getRacersList;
import static dao.DAO.getStartTime;

public class Service {
    public static void main(String[] args) {
        //List<RacerModel> humanModelList = getRacersList();

        //System.out.println(humanModelList);
        List<TimeStartModel> timeStartModelList = getStartTime();
        System.out.println(timeStartModelList);
    }

}
