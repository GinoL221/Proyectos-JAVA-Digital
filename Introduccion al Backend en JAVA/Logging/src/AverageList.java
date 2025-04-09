import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AverageList {

    private static final Logger logger = Logger.getLogger(AverageList.class); // Log4j logger
    private List<Integer> integerList = new ArrayList<>();

    public AverageList(List<Integer> integers) throws Exception {
        this.integerList = integers;
        if(integers.isEmpty()) {
            throw new Exception("La lista está vacía");
        }
        if(integers.size() > 5){
            logger.info("La longitud de la lista es mayor a 5 y el promedio es: " + average());
        }
        if(integers.size() > 10){
            logger.info("La longitud de la lista es mayor a 10 y el promedio es: " + average());
        }
    }

    public int average(){
        int sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        return sum / integerList.size();
    }
}
