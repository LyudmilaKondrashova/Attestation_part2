package toyshop.model;

import java.util.ArrayList;

public interface ToyOperation {
    ArrayList<Toy> getAllToys(String fileName);   // Получение списка всех игрушек

    int addToy(Toy toy);   // Добавление новой игрушки

    boolean changeDrop(int id, int drop); // Изменение частоты выпадения игрушки (вес в % от 100)

    Toy lotOneToy();    // Розыгрыш одной игрушки

    ArrayList<Toy> toysAfterDraw(ArrayList<Toy> toys, Toy lotToy);    // Уменьшение количества игрушек после розыгрыша

    void giveToy(Toy toy); // Выдача призовой игрушки

    void writeToys(String fileName, ArrayList<Toy> toys);    // Запись всех игрушек в файл

    void writePresentToy(String fileName, Toy toy);  // Запись выданной игрушки в файл
}
