package Service;

import Organisms.Animals.Herbivores.*;
import Organisms.Animals.Predators.*;
import Organisms.Organism;
import Organisms.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class View {
    public void show(HashMap<Class<? extends Organism>, Integer> collection){
        Map<Class<? extends Organism>, String> emojisMap = new HashMap<>();
        Map<String, Integer> mapToDisplay = new HashMap<>();
        emojisMap.put(Grass.class, "\uD83C\uDF3F Grass ");
        emojisMap.put(Boar.class, "\uD83D\uDC17 Boar ");
        emojisMap.put(Buffalo.class, "\uD83D\uDC03 Buffalo ");
        emojisMap.put(Caterpillar.class, "\uD83D\uDC1B Caterpillar ");
        emojisMap.put(Deer.class, "\uD83E\uDD8C Deer ");
        emojisMap.put(Duck.class, "\uD83E\uDD86 Duck ");
        emojisMap.put(Goose.class, "\uD83E\uDD86 Goose ");
        emojisMap.put(Goat.class, "\uD83D\uDC10 Goat ");
        emojisMap.put(Horse.class, "\uD83D\uDC0E Horse ");
        emojisMap.put(Mouse.class, "\uD83D\uDC01 Mouse ");
        emojisMap.put(Rabbit.class, "\uD83D\uDC07 Rabbit ");
        emojisMap.put(Sheep.class, "\uD83D\uDC11 Sheep ");
        emojisMap.put(Bear.class, "\uD83D\uDC3B Bear ");
        emojisMap.put(Boa.class, "\uD83D\uDC0D Boa ");
        emojisMap.put(Eagle.class, "\uD83E\uDD85 Eagle ");
        emojisMap.put(Fox.class, "\uD83E\uDD8A Fox ");
        emojisMap.put(Wolf.class, "\uD83D\uDC3A Wolf ");

        for(Map.Entry<Class<? extends Organism>, Integer> innerCollection : collection.entrySet()){
            mapToDisplay.put(emojisMap.get(innerCollection.getKey()), innerCollection.getValue());
        }
        for(Map.Entry<String, Integer> display : mapToDisplay.entrySet()){
            System.out.println(display.getKey() + "= " + display.getValue());
        }
    }
}
