package controller;

import utils.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputController {



    public InputController(){};

    public boolean checkInRange(int num, int min, int max){

        return num > min && num < max;
    }


    public Date converDate(String date) {
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");

        Date d = null;
        try {
            d = formatter1.parse(date);
            return d;
        } catch (ParseException e) {
            return null;
        }
    }

    public boolean checkInt(int voto) {

            return true;
    }


}
