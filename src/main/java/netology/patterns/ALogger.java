package netology.patterns;

import java.util.Date;

public class ALogger implements ILogger{
    private static ALogger instance;

    private int counter;

    private ALogger(){
    }

    public static ALogger getInstance(){
        if (instance == null) {
            return new ALogger();
        } else {
            return instance;
        }
    }

    @Override
    public void log(String str) {
        counter++;
        Date currentTime = new Date();
        System.out.println(currentTime.toString() + " " + counter + " " + str);
    }

}
