package toyshop.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static toyshop.model.Constants.FILETOYSNAME;
import static toyshop.model.Constants.FILEPRESENTTOYSNAME;

public class ToyOperationImpl implements ToyOperation {
    private FileOperation fileOperation;
    private ToyConverter toyConverter = new ToyConverter();

    public ToyOperationImpl(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    // Получение списка всех готовых к розыгрышу игрушек
    @Override
    public ArrayList<Toy> getAllToys(String fileName) {
        ArrayList<String> toyList = fileOperation.readAllToys(fileName);
        ArrayList<Toy> toys = new ArrayList<>();
        for (String line : toyList) {
            toys.add(toyConverter.convert(line));
        }
        return toys;
    }

    // Добавление новой игрушки
    @Override
    public int addToy(Toy toy) {
        ArrayList<Toy> toys = getAllToys(FILETOYSNAME);
        int max = 0;
        for (Toy item : toys) {
            int id = item.getId();
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        toy.setId(newId);
        toys.add(toy);
        writeToys(FILETOYSNAME, toys);
        return newId;
    }

    // Изменение частоты выпадения игрушки (вес в % от 100)
    @Override
    public boolean changeDrop(int idToy, int dropToy) {
        ArrayList<Toy> toys = getAllToys(FILETOYSNAME);
        boolean flag = false;
        for (Toy item : toys) {
            int currentId = item.getId();
            if (currentId == idToy) {
                item.setDrop(dropToy);
                flag = true;
            }
        }
        writeToys(FILETOYSNAME,toys);
        return flag;
    }

    @Override
    public Toy lotOneToy() {
        ArrayList<Toy> toys = getAllToys(FILETOYSNAME);
        boolean flag = false;
        while (!flag) {
            int currentDrop = new Random().nextInt(0, 101);
            ArrayList<Toy> lotToys = new ArrayList<>();
            for (Toy item : toys) {
                if (currentDrop == item.getDrop()) {
                    lotToys.add(item);
                }
            }
            int sizeLot = lotToys.size();
            if (sizeLot > 0) {
                if (sizeLot == 1) {
                    return lotToys.get(0);
                } else {
                    int currentLot = new Random().nextInt(1, sizeLot);
                    return lotToys.get(currentLot);
                }
            }
        }
        return null;
    }

    @Override
    public void presentToy(int idNote) {

    }

    // Запись всех игрушек в файл
    private void writeToys(String fileName, ArrayList<Toy> toys) {
        ArrayList<String> toysList = new ArrayList<>();
        for (Toy item : toys) {
            toysList.add(toyConverter.convert(item));
        }
        fileOperation.saveAllToys(fileName, toysList);
    }
}