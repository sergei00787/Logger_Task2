package netology.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ALogger logger = ALogger.getInstance();

        System.out.println("Привет. Для запуска требуется ввести 2 числа.");
        logger.log("Приветствие пользователя");

        Scanner scanner = new Scanner(System.in);

        int countElements = 0;
        countElements = getCountElements(logger, scanner, countElements);

        int maxNumberValue = 0;
        maxNumberValue = getMaxNumberValue(logger, scanner, maxNumberValue);

        logger.log("Создаём и наполняем список");
        List<Integer> arrNums = fillListNums(countElements, maxNumberValue);
        System.out.println("Вот случайный список " + arrNums.toString());

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filteredNumber = Integer.MAX_VALUE;
        filteredNumber = getFilteredNumber(logger, scanner, filteredNumber);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filteredNumber);

        List<Integer> filteredList = filter.filterOut(arrNums);

        logger.log("Выводим результат");
        System.out.println("Отфильтрованный список " + filteredList.toString());
        logger.log("Завершаем программу");


    }

    private static int getFilteredNumber(ALogger logger, Scanner scanner, int filteredNumber) {
        while (filteredNumber == Integer.MAX_VALUE) {
            System.out.println("Введите порог для фильтра");
            String strFilteredValue = scanner.next();
            try {
                filteredNumber = Integer.parseInt(strFilteredValue);
                if (filteredNumber < 0) {
                    filteredNumber = 0;
                    logger.log("Введено неверное число порог для фильтра " + filteredNumber);
                    System.out.println("Введенное значение не может быть меньше нуля. Попробуйте ввод снова.");
                }
            } catch (NumberFormatException nfe) {
                logger.log("Введено неверное число число порог для фильтра " + strFilteredValue);
                System.out.println("Введено некорректное число. Повторите ввод.");
            }
        }
        return filteredNumber;
    }

    private static int getMaxNumberValue(ALogger logger, Scanner scanner, int maxNumberValue) {
        while (maxNumberValue == 0) {
            System.out.println("Введите верхнюю границу для значений");
            String strMaxValue = scanner.next();
            try {
                maxNumberValue = Integer.parseInt(strMaxValue);
                if (maxNumberValue < 0) {
                    maxNumberValue = 0;
                    logger.log("Введено неверное число верхней границы для значений " + maxNumberValue);
                    System.out.println("Введенное значение не может быть меньше нуля. Попробуйте ввод снова.");
                }
            } catch (NumberFormatException nfe) {
                logger.log("Введено неверное число верхней границы для значений " + strMaxValue);
                System.out.println("Введено некорректное число. Повторите ввод.");
            }
        }
        return maxNumberValue;
    }

    private static int getCountElements(ALogger logger, Scanner scanner, int countElements) {
        while (countElements == 0) {
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка:");
            String strNum = scanner.next();
            try {
                countElements = Integer.parseInt(strNum);
                if (countElements < 0) {
                    countElements = 0;
                    logger.log("Введено неверное число размер списка: " + countElements);
                    System.out.println("Введенное значение не может быть меньше нуля. Попробуйте ввод снова.");
                }
            } catch (NumberFormatException nfe) {
                logger.log("Введено неверное число размер списка: " + strNum);
                System.out.println("Введено некорректное число. Повторите ввод.");
            }
        }
        return countElements;
    }

    public static List<Integer> fillListNums(int countElements, int maxValue) {
        Random random = new Random();
        List<Integer> listNums = new ArrayList<>();
        for (int i = 0; i < countElements; i++) {
            listNums.add(random.nextInt(maxValue));
        }
        return listNums;
    }
}
