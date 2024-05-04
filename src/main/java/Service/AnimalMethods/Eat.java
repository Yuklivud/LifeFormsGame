package Service.AnimalMethods;

import Organisms.Animals.Animal;
import Organisms.Animals.Herbivores.*;
import Organisms.Animals.Predators.*;
import Organisms.Organism;
import Organisms.Plants.Plant;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Eat {
    public static Map<Class<? extends Organism>, HashMap<Class<? extends Organism>, Integer>> predatorOdds = new HashMap<>();
    public static Map<Class<? extends Organism>, HashMap<Class<? extends Organism>, Integer>> herbivoresOdds = new HashMap<>();

    static {
        initializationHuntOdds();
    }
    public void predatorEat(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int currentPosition, Class<? extends Organism> organismClass) {
        HashMap<Class<? extends Organism>, Integer> mapFromCollection = collection.get(currentPosition);
        HashMap<Class<? extends Organism>, Integer> mapFromOdds = predatorOdds.get(organismClass);
        try{
            for(Map.Entry<Class<? extends Organism>, Integer> entry : mapFromCollection.entrySet()){
                if(entry.getValue() > 0 ){
                    int huntOdd = ThreadLocalRandom.current().nextInt(101);
                    int oddsFromEntry = mapFromOdds.get(entry.getKey());
                    if(huntOdd > oddsFromEntry){
                        Animal animal = (Animal) organismClass.getDeclaredConstructor().newInstance();
                        Class<? extends Organism> hunted = entry.getKey();
                        Animal huntedAnimal = (Animal) hunted.getDeclaredConstructor().newInstance();
                        animal.setCountFood(animal.getCountFood() + huntedAnimal.getFoodValue());
                        deleteValueCollection(mapFromCollection, hunted);
                        collection.put(currentPosition, mapFromCollection);
                    }
                }
            }
        } catch (Exception ignored){}
    }

    public void herbivoresEat(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int currentPosition, Class<? extends Organism> organismClass){
        HashMap<Class<? extends Organism>, Integer> mapFromCollection = collection.get(currentPosition);
        HashMap<Class<? extends Organism>, Integer> mapFromOdds = herbivoresOdds.get(organismClass);

        try{
            for(Map.Entry<Class<? extends Organism>, Integer> entry : mapFromCollection.entrySet()){
                if(entry.getValue() > 0 ){
                    int huntOdd = ThreadLocalRandom.current().nextInt(101);
                    int oddsFromEntry = mapFromOdds.get(entry.getKey());
                    if(huntOdd > oddsFromEntry){
                        Animal animal = (Animal) organismClass.getDeclaredConstructor().newInstance();
                        Class<? extends Organism> hunted = entry.getKey();
                        Animal huntedAnimal = (Animal) hunted.getDeclaredConstructor().newInstance();
                        animal.setCountFood(animal.getCountFood() + huntedAnimal.getFoodValue());
                        deleteValueCollection(mapFromCollection, hunted);
                        collection.put(currentPosition, mapFromCollection);
                    }
                }
            }
        } catch (Exception ignored){}

    }
    public void deleteValueCollection(HashMap<Class<? extends Organism>, Integer> collection, Class<? extends Organism> organismClass){
        int currentValue = collection.get(organismClass);
        int newValue = currentValue - 1;
        collection.put(organismClass, newValue);
    }
    public static void initializationHuntOdds(){
        HashMap<Class<? extends Organism>, Integer> wolfOdds = new HashMap<>();

        wolfOdds.put(Wolf.class, 0);
        wolfOdds.put(Boa.class, 0);
        wolfOdds.put(Fox.class, 15);
        wolfOdds.put(Bear.class, 0);
        wolfOdds.put(Eagle.class, 0);
        wolfOdds.put(Horse.class, 10);
        wolfOdds.put(Deer.class, 15);
        wolfOdds.put(Rabbit.class, 60);
        wolfOdds.put(Mouse.class, 80);
        wolfOdds.put(Goat.class, 60);
        wolfOdds.put(Sheep.class, 70);
        wolfOdds.put(Boar.class, 15);
        wolfOdds.put(Buffalo.class, 10);
        wolfOdds.put(Duck.class, 40);
        wolfOdds.put(Goose.class, 10);
        wolfOdds.put(Caterpillar.class, 0);
        wolfOdds.put(Plant.class, 0);

        HashMap<Class<? extends Organism>, Integer> boaOdds = new HashMap<>();

        boaOdds.put(Wolf.class, 0);
        boaOdds.put(Boa.class, 0);
        boaOdds.put(Fox.class, 15);
        boaOdds.put(Bear.class, 0);
        boaOdds.put(Eagle.class, 0);
        boaOdds.put(Horse.class, 0);
        boaOdds.put(Deer.class, 0);
        boaOdds.put(Rabbit.class, 20);
        boaOdds.put(Mouse.class, 40);
        boaOdds.put(Goat.class, 0);
        boaOdds.put(Sheep.class, 0);
        boaOdds.put(Boar.class, 0);
        boaOdds.put(Buffalo.class, 0);
        boaOdds.put(Duck.class, 10);
        boaOdds.put(Goose.class, 10);
        boaOdds.put(Caterpillar.class, 0);
        boaOdds.put(Plant.class, 0);

        HashMap<Class<? extends Organism>, Integer> foxOdds = new HashMap<>();

        foxOdds.put(Wolf.class, 0);
        foxOdds.put(Boa.class, 0);
        foxOdds.put(Fox.class, 0);
        foxOdds.put(Bear.class, 0);
        foxOdds.put(Eagle.class, 0);
        foxOdds.put(Horse.class, 0);
        foxOdds.put(Deer.class, 0);
        foxOdds.put(Rabbit.class, 70);
        foxOdds.put(Mouse.class, 90);
        foxOdds.put(Goat.class, 0);
        foxOdds.put(Sheep.class, 0);
        foxOdds.put(Boar.class, 0);
        foxOdds.put(Buffalo.class, 0);
        foxOdds.put(Duck.class, 60);
        foxOdds.put(Goose.class, 10);
        foxOdds.put(Caterpillar.class, 40);
        foxOdds.put(Plant.class, 0);

        HashMap<Class<? extends Organism>, Integer> bearOdds = new HashMap<>();

        bearOdds.put(Wolf.class, 0);
        bearOdds.put(Boa.class, 80);
        bearOdds.put(Fox.class, 0);
        bearOdds.put(Bear.class, 0);
        bearOdds.put(Eagle.class, 0);
        bearOdds.put(Horse.class, 40);
        bearOdds.put(Deer.class, 80);
        bearOdds.put(Rabbit.class, 80);
        bearOdds.put(Mouse.class, 90);
        bearOdds.put(Goat.class, 70);
        bearOdds.put(Sheep.class, 70);
        bearOdds.put(Boar.class, 50);
        bearOdds.put(Buffalo.class, 20);
        bearOdds.put(Duck.class, 10);
        boaOdds.put(Goose.class, 10);
        bearOdds.put(Caterpillar.class, 0);
        bearOdds.put(Plant.class, 0);

        HashMap<Class<? extends Organism>, Integer> eagleOdds = new HashMap<>();

        eagleOdds.put(Wolf.class, 0);
        eagleOdds.put(Boa.class, 0);
        eagleOdds.put(Fox.class, 10);
        eagleOdds.put(Bear.class, 0);
        eagleOdds.put(Eagle.class, 0);
        eagleOdds.put(Horse.class, 0);
        eagleOdds.put(Deer.class, 0);
        eagleOdds.put(Rabbit.class, 90);
        eagleOdds.put(Mouse.class, 90);
        eagleOdds.put(Goat.class, 0);
        eagleOdds.put(Sheep.class, 0);
        eagleOdds.put(Boar.class, 0);
        eagleOdds.put(Buffalo.class, 0);
        eagleOdds.put(Duck.class, 80);
        eagleOdds.put(Goose.class, 10);
        eagleOdds.put(Caterpillar.class, 40);
        eagleOdds.put(Plant.class, 0);

        predatorOdds.put(Wolf.class, wolfOdds);
        predatorOdds.put(Bear.class, bearOdds);
        predatorOdds.put(Eagle.class, eagleOdds);
        predatorOdds.put(Boa.class, boaOdds);
        predatorOdds.put(Fox.class, foxOdds);


        // Herbivores
        
        HashMap<Class<? extends Organism>, Integer> horseOdds = new HashMap<>();

        horseOdds.put(Caterpillar.class, 0);
        horseOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> deerOdds = new HashMap<>();

        deerOdds.put(Caterpillar.class, 0);
        deerOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> rabbitOdds = new HashMap<>();

        rabbitOdds.put(Caterpillar.class, 0);
        rabbitOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> mouseOdds = new HashMap<>();

        mouseOdds.put(Caterpillar.class, 90);
        mouseOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> goatOdds = new HashMap<>();

        goatOdds.put(Caterpillar.class, 0);
        goatOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> sheepOdds = new HashMap<>();

        sheepOdds.put(Caterpillar.class, 0);
        sheepOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> boarOdds = new HashMap<>();

        boarOdds.put(Caterpillar.class, 90);
        boarOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> buffaloOdds = new HashMap<>();

        buffaloOdds.put(Caterpillar.class, 0);
        buffaloOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> gooseOdds = new HashMap<>();

        gooseOdds.put(Caterpillar.class, 40);
        gooseOdds.put(Plant.class, 100);

        HashMap<Class<? extends Organism>, Integer> caterpillarOdds = new HashMap<>();

        caterpillarOdds.put(Caterpillar.class, 40);
        caterpillarOdds.put(Plant.class, 100);

        herbivoresOdds.put(Horse.class, horseOdds);
        herbivoresOdds.put(Deer.class, deerOdds);
        herbivoresOdds.put(Rabbit.class, rabbitOdds);
        herbivoresOdds.put(Mouse.class, mouseOdds);
        herbivoresOdds.put(Goat.class, goatOdds);
        herbivoresOdds.put(Sheep.class, sheepOdds);
        herbivoresOdds.put(Boar.class, boarOdds);
        herbivoresOdds.put(Buffalo.class, buffaloOdds);
        herbivoresOdds.put(Goose.class, gooseOdds);
        herbivoresOdds.put(Caterpillar.class, caterpillarOdds);
    }
}
