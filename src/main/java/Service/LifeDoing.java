package Service;

import Organisms.Animals.Animal;
import Organisms.Organism;
import Organisms.Plants.Grass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LifeDoing {
    public Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection;

    public LifeDoing(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        this.collection = collection;
    }

    public void simulation(HashMap<Class<? extends Organism>, Integer> collectionToView) {
        aCalculateAnimals(collection, collectionToView);
        aEat(collection);
        aMultiply(collection);
        aMove(collection);
        aDead(collection);
        aStarve(collection);
        aGrowGrass(collection);
    }

    public void aMove(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            int counter = entry.getKey();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                if (innerEntry.getValue() > 0 && innerEntry.getKey() != Grass.class) {
                    Class<? extends Organism> animalClass = innerEntry.getKey();
                    for (int i = 0; i < innerEntry.getValue(); i++) {
                        try {
                            Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
                            animal.move(collection, counter);
                        } catch (Exception ignored) {}
                    }
                }
            }
        }
    }

    public void aEat(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            int counter = entry.getKey();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                if (innerEntry.getValue() > 0 && innerEntry.getKey() != Grass.class) {
                    Class<? extends Organism> animalClass = innerEntry.getKey();

                    for (int i = 0; i < innerEntry.getValue(); i++) {
                        try {
                            Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
                            if (animal.getCountFood() < animal.getNeedFoodCount()) {
                                animal.eat(collection, counter);
                            }
                        } catch (Exception ignored) {}
                    }
                }
            }
        }
    }

    public void aMultiply(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            int counter = entry.getKey();
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                try {
                    if (innerEntry.getValue() > 1 && innerEntry.getKey() != Grass.class) {
                        Class<? extends Organism> animalClass = innerEntry.getKey();
                        Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
                        animal.multiply(collection, counter);
                    }
                } catch (Exception ignored) {}
            }
        }
    }

    public void aDead(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            int counter = entry.getKey();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                if (innerEntry.getValue() > 0 && innerEntry.getKey() != Grass.class) {
                    Class<? extends Organism> animalClass = innerEntry.getKey();

                    for (int i = 0; i < innerEntry.getValue(); i++) {
                        try {
                            Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
                            if (animal.getNeedFoodCount() > animal.getCountFood()) {
                                animal.dead(collection, counter);
                            }
                        } catch (Exception ignored) {}
                    }
                }
            }
        }
    }

    public void aGrowGrass(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        Random random = new Random();
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            innerMap.put(Grass.class, random.nextInt(51));
            collection.put(entry.getKey(), innerMap);
        }
    }

    public void aStarve(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection) {
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                if (innerEntry.getValue() > 0 && innerEntry.getKey() != Grass.class) {
                    Class<? extends Organism> animalClass = innerEntry.getKey();

                    for (int i = 0; i < innerEntry.getValue(); i++) {
                        try {
                            Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();
                            animal.setCountFood(animal.getCountFood() - animal.getNeedFoodCount());
                        } catch (Exception ignored) {}
                    }
                }
            }
        }
    }

    public void aCalculateAnimals(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, HashMap<Class<? extends Organism>, Integer> collectionToView) {
        HashMap<Class<? extends Organism>, Integer> collectionToReplace = new HashMap<>();
        for (Map.Entry<Integer, HashMap<Class<? extends Organism>, Integer>> entry : collection.entrySet()) {
            HashMap<Class<? extends Organism>, Integer> innerMap = entry.getValue();
            for (Map.Entry<Class<? extends Organism>, Integer> innerEntry : innerMap.entrySet()) {
                collectionToReplace.merge(innerEntry.getKey(), innerEntry.getValue(), Integer::sum);
            }
        }
        collectionToView.clear();
        collectionToView.putAll(collectionToReplace);
    }
}
