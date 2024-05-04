package Organisms.Animals.Herbivores;

import Organisms.Organism;
import Service.AnimalMethods.Dead;
import Service.AnimalMethods.Eat;
import Service.AnimalMethods.Move;
import Service.AnimalMethods.Multiply;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Caterpillar implements Herbivore{
    private Random random = new Random();
    private final int WEIGHT = 1;
    private final int MOVEMENT_SPEED = 0;
    private int foodCount = 0;
    private final int FOOD_NEED = 0;

    public int getMOVEMENT_SPEED() {
        return MOVEMENT_SPEED;
    }


    @Override
    public void eat(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position) {
        Eat eat = new Eat();
        eat.herbivoresEat(collection, position, this.getClass());
    }

    @Override
    public void move(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position) {
        int side = random.nextInt(5);
        Move movement = new Move();
        movement.move(collection, position, side, getMOVEMENT_SPEED(), this.getClass());
    }

    @Override
    public void dead(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position) {
        Dead aDead = new Dead();
        aDead.dead(collection, position, this.getClass());
    }

    @Override
    public void multiply(Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection, int position) {
        Multiply aMultiply = new Multiply();
        aMultiply.animalMultiply(collection, position, this.getClass());
    }

    @Override
    public int getCountFood() {
        return foodCount;
    }

    @Override
    public void setCountFood(int i) {
        this.foodCount = i;
    }

    @Override
    public int getFoodValue() {
        return WEIGHT;
    }

    @Override
    public int getNeedFoodCount() {
        return FOOD_NEED;
    }
}
