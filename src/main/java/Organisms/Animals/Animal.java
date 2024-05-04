package Organisms.Animals;

import Organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public interface Animal extends Organism {

    void eat(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position);
    void move(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position);
    void dead(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position);
    void multiply(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position);
}
