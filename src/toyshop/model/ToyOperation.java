package toyshop.model;

import java.util.ArrayList;

public interface ToyOperation {
    ArrayList<Toy> getAllToys(String fileName);   // Получение списка всех игрушек

    int addToy(Toy toy);   // Добавление новой игрушки

    boolean changeDrop(int id, int drop); // Изменение частоты выпадения игрушки (вес в % от 100)

    Toy lotOneToy();    // Розыгрыш одной игрушки

    void presentToy(int idNote); // Выдача призовой игрушки
}
