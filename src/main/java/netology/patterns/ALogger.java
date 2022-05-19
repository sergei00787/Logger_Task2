package netology.patterns;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")).toString() + " " + counter + " " + str);
    }

}
