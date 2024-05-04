package Service.AnimalMethods;

import Organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Move {

    public void move(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, int side, int movementSpeed, Class<? extends Organism> organismClass){
        if (side == 1 && isValidUpMove(position, movementSpeed)) {
            // Up
            goUp(collection, position, movementSpeed, organismClass);
        } else if (side == 2 && isValidRightMove(position, movementSpeed)) {
            // Right
            goRight(collection, position, movementSpeed, organismClass);
        } else if (side == 3 && isValidDownMove(position, movementSpeed)) {
            // Down
            goDown(collection, position, movementSpeed, organismClass);
        } else if (side == 4 && isValidLeftMove(position, movementSpeed)) {
            // Left
            goLeft(collection, position, movementSpeed, organismClass);
        } else {}
    }
    public void goUp(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, int movementSpeed, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapToDelete = collection.get(position);
        deleteValueCollection(mapToDelete, organismClass);
        collection.put(position, mapToDelete);
        HashMap<Class<? extends Organism>, Integer> mapToAdd = collection.get(position - (movementSpeed * 79));
        addValueCollection(mapToAdd, organismClass);
        collection.put(position - (movementSpeed * 79), mapToAdd);
    }

    public void goRight(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, int movementSpeed, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapToDelete = collection.get(position);
        deleteValueCollection(mapToDelete, organismClass);
        collection.put(position, mapToDelete);
        HashMap<Class<? extends Organism>, Integer> mapToAdd = collection.get(position + 1);
        addValueCollection(mapToAdd, organismClass);
        collection.put(position + 1, mapToAdd);
    }

    public void goLeft(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, int movementSpeed, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapToDelete = collection.get(position);
        deleteValueCollection(mapToDelete, organismClass);
        collection.put(position, mapToDelete);
        HashMap<Class<? extends Organism>, Integer> mapToAdd = collection.get(position - 1);
        addValueCollection(mapToAdd, organismClass);
        collection.put(position - 1, mapToAdd);
    }

    public void goDown(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position, int movementSpeed, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapToDelete = collection.get(position);
        deleteValueCollection(mapToDelete, organismClass);
        collection.put(position, mapToDelete);
        HashMap<Class<? extends Organism>, Integer> mapToAdd = collection.get(position + (movementSpeed * 79));
        addValueCollection(mapToAdd, organismClass);
        collection.put(position + (movementSpeed * 79), mapToAdd);
    }
    public void deleteValueCollection(HashMap<Class<? extends Organism>, Integer> collection, Class<? extends Organism> organismClass){
        int currentValue = collection.get(organismClass);
        int newValue = currentValue - 1;
        collection.put(organismClass, newValue);
    }
    public void addValueCollection(HashMap<Class<? extends Organism>, Integer> collection, Class<? extends Organism> organismClass){
        int newValue = collection.get(organismClass) + 1;
        collection.put(organismClass, newValue);
    }
    public boolean isValidUpMove(int position, int movementSpeed){
        return position - (movementSpeed * 79) >= 0;
    }

    public boolean isValidDownMove(int position, int movementSpeed){
        return position + (movementSpeed * 79) < 2000;
    }

    public boolean isValidLeftMove(int position, int movementSpeed){
        return position - movementSpeed >= 0;
    }

    public boolean isValidRightMove(int position, int movementSpeed){
        return position + movementSpeed < 2000;
    }
}
