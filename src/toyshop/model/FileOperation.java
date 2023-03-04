package toyshop.model;

import java.util.ArrayList;

public interface FileOperation {
    // Получение из файла списка всех игрушек
    ArrayList<String> readAllToys(String fileName);

    // Запись в файл списка всех игрушек
    void saveAllToys(String fileName, ArrayList<String> toys);

//    // Получение из файла списка игрушек
//    ArrayList<String> readAllPresentToys();
//
//    // Запись в файл призовых игрушек списка игрушек
//    void saveAllPresentToys(ArrayList<String> toys);
}
