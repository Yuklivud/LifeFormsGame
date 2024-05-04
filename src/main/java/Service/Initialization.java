package Service;

import Organisms.Animals.Herbivores.*;
import Organisms.Animals.Predators.*;
import Organisms.Organism;
import Organisms.Plants.Grass;

import java.util.*;

public class Initialization {
    private final Random RANDOM = new Random();

    public void initSymbols(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int cellsNumbers) {

        for (int i = 0; i < cellsNumbers; i++) {
            createLife(collection, i);
        }
    }

    private void createLife(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int numberOfCell) {
        HashMap<Class<? extends Organism>, Integer> content = new HashMap<>();
        // Predators

        content.put(Bear.class, RANDOM.nextInt(6));
        content.put(Wolf.class, RANDOM.nextInt(1, 31));
        content.put(Boa.class, RANDOM.nextInt(31));
        content.put(Eagle.class, RANDOM.nextInt(21));
        content.put(Fox.class, RANDOM.nextInt(31));

        // Herbivores

        content.put(Horse.class, RANDOM.nextInt(21));
        content.put(Boar.class, RANDOM.nextInt(51));
        content.put(Buffalo.class, RANDOM.nextInt(11));
        content.put(Deer.class, RANDOM.nextInt(21));
        content.put(Duck.class, RANDOM.nextInt(201));
        content.put(Goat.class, RANDOM.nextInt(141));
        content.put(Goose.class, RANDOM.nextInt(21));
        content.put(Mouse.class, RANDOM.nextInt(501));
        content.put(Rabbit.class, RANDOM.nextInt(151));
        content.put(Sheep.class, RANDOM.nextInt(141));
        content.put(Caterpillar.class, RANDOM.nextInt(1001));

        // Plants

        content.put(Grass.class, RANDOM.nextInt(201));

        collection.put(numberOfCell, content);
    }
}