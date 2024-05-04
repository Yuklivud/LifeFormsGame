package Service.AnimalMethods;

import Organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Dead {
    public void dead(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, Class<? extends Organism> organismClass){
        try{
            HashMap<Class<? extends Organism>, Integer> mapToKill = collection.get(position);
            int currentInt = mapToKill.get(organismClass);
            int newInt = currentInt - 1;
            mapToKill.put(organismClass, newInt);
            collection.put(position, mapToKill);
        } catch (Exception ignored) {}


    }
}
