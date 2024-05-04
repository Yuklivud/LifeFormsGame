package Organisms.Plants;

public class Grass implements Plant{

    @Override
    public int getCountFood() {
        return 0;
    }

    @Override
    public void setCountFood(int i) {

    }

    @Override
    public int getFoodValue() {
        return 1;
    }

    @Override
    public int getNeedFoodCount() {
        return 0;
    }
}
