import Service.Initialization;
import Service.LifeDoing;
import Service.View;
import Organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Runner implements Runnable {
    public Map<Integer, HashMap<Class<? extends Organism>, Integer>> collection = new HashMap<>();
    public HashMap<Class<? extends Organism>, Integer> collectionToView = new HashMap<>();
    public int cellsNumber = 2_000;
    public LifeDoing lf = new LifeDoing(collection);
    public View view = new View();
    public int counter = 1;

    // Init block
    {
        System.out.println("Initialization");
        Initialization initialization = new Initialization();
        initialization.initSymbols(collection, cellsNumber);
    }

    @Override
    public void run() {
        lf.simulation(collectionToView);
        System.out.println("\nTotal amount of animals.");
        System.out.println("Round  = " + counter + "\n");
        view.show(collectionToView);
        counter++;
    }
}
