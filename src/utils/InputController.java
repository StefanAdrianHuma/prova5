package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InputController {
    
        private static InputController inputController;
    
        private InputController() {
        }

        public static InputController getIstance(){
            if(inputController==null){
                inputController= new InputController();
            }
            return inputController;
        }


            public Date converDate(String data) {

            System.out.println(data);
                data = data.replace('-','/');


                try{

                    Date d = new SimpleDateFormat("yyyy/MM/dd").parse(data);
                    System.out.println(d);


                    return d;

                }catch(ParseException ps){
                    ps.printStackTrace();
                    return null;
                }
    }
    public int StringToInt(String value){

        try {
            return Integer.parseInt(value);
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public Date generateDate(int day_index, int index, int year) {

        return new GregorianCalendar(year, index - 1, day_index).getTime();
    }
}
