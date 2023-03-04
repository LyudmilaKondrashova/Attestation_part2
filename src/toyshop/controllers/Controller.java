package toyshop.controllers;

import toyshop.model.Toy;
import toyshop.model.ToyOperation;
import static toyshop.model.Constants.FILETOYSNAME;
import static toyshop.model.Constants.FILEPRESENTTOYSNAME;
import java.util.ArrayList;

public class Controller {
    private final ToyOperation toyOperation;

    public Controller(ToyOperation toyOperation) {
        this.toyOperation = toyOperation;
    }

    public void saveToy(Toy toy) {
        toyOperation.addToy(toy);
    }

    public ArrayList<Toy> readToyList() {
        ArrayList<Toy> toys = toyOperation.getAllToys(FILETOYSNAME);
        return toys;
    }

    public boolean changeToyDrop(int idToy, int dropToy) {
        return toyOperation.changeDrop(idToy, dropToy);
    }

    public Toy lotToy() {
        return  toyOperation.lotOneToy();
    }
}
