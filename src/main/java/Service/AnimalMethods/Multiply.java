package Service.AnimalMethods;

import Organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Multiply {
    public void animalMultiply(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapToMultiply = collection.get(position);
        int currentInt = mapToMultiply.get(organismClass);
        int newInt = currentInt + currentInt / 2;
        mapToMultiply.put(organismClass, newInt);
        collection.put(position, mapToMultiply);
    }
}
