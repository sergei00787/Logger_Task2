package netology.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> listNums = new ArrayList<>();

        ALogger logger = ALogger.getInstance();

        System.out.println("Hello. Input 2 numbers:");
        logger.log("Hello with User");

        Scanner scanner = new Scanner(System.in);
        int countElements = 0;

        while (countElements == 0){
            logger.log("Question input count elements");
            System.out.println("Input count elements in list:");
            String strNum = scanner.next();
            try {
                countElements = Integer.parseInt(strNum);
                if (countElements < 0) {
                    countElements = 0;
                    logger.log("Vvedeno nekorrektnoe chislo: " + countElements);
                    System.out.println("Inputed value less then 0. Repeat input.");
                }
            } catch (NumberFormatException nfe){
                logger.log("Vvedeno nekorrektnoe chislo: " + strNum);
                System.out.println("Inputed string is not Integer. Repeat input.");
            }
        }

        int maxNumberValue = 0;
        while (maxNumberValue == 0){
            System.out.println("Input max value elements in list");
            String strMaxValue = scanner.next();
            try {
                maxNumberValue = Integer.parseInt(strMaxValue);
                if (maxNumberValue < 0) {
                    maxNumberValue = 0;
                    logger.log("Vvedeno nekorrektnoe chislo: " + maxNumberValue);
                    System.out.println("Inputed value less then 0 Repeat input.");
                }
            } catch (NumberFormatException nfe){
                logger.log("Vvedeno nekorrektnoe chislo: " + strMaxValue);
                System.out.println("Inputed string is not Integer. Repeat input.");
            }
        }

        logger.log("Sozdayom i zapolnyaem spisok");
        List<Integer> arrNums = fillListNums(countElements, maxNumberValue);
        System.out.println("Vot sluchayniy spisok " + arrNums.toString());

    }

    public static List<Integer> fillListNums(int countElements, int maxValue){
        Random random = new Random();
        List<Integer> listNums = new ArrayList<>();
        for (int i = 0; i < countElements; i++) {
            listNums.add(random.nextInt(maxValue));
        }
        return listNums;
    }
}
