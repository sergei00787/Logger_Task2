package netology.patterns;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    int filteredNum;

    public Filter(int filteredNum) {
        this.filteredNum = filteredNum;
    }

    public List<Integer> filterOut(List<Integer> list) {
        ALogger logger = ALogger.getInstance();
        List<Integer> resultList = list.stream().filter((num) -> {
            if (num > filteredNum) {
                logger.log("Элемент " + num + " проходит");
                return true;
            } else {
                logger.log("Элемент " + num + " не проходит");
                return false;
            }
        }).collect(Collectors.toList());

        logger.log("Прошло фильтр " + resultList.size() + " элементов из " + list.size());
        return resultList;
    }
}
