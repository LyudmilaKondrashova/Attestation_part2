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

    // Добавить игрушку в список разыгрываемых игрушек
    public void saveToy(Toy toy) {
        toyOperation.addToy(toy);
    }

    // Чтение из файла спискк всех разыгрываемых игрушек
    public ArrayList<Toy> readToyList() {
        ArrayList<Toy> toys = toyOperation.getAllToys(FILETOYSNAME);
        return toys;
    }

    // Получение списка всех выданных игрушек
    public ArrayList<String> readPresentToyList() {
        ArrayList<String> toys = toyOperation.getAllPresentToys(FILEPRESENTTOYSNAME);
        return toys;
    }

    // Изменить вес (частоту выпадения) игрушки
    public boolean changeToyDrop(int idToy, int dropToy) {
        return toyOperation.changeDrop(idToy, dropToy);
    }

    // Провести розыгрыш одной игрушки
    public Toy lotToy() {
        return  toyOperation.lotOneToy();
    }

    // Удалить выданную игрушку из списка разыгранных
    public void giveAwayToy(Toy toy) {
        toyOperation.giveToy(toy);
    }

    // Очистка файла выданных игрушек при окончании работы программы
    public void clearPresentFile() {
        toyOperation.clearFile();
    }
}
