package dao;

import models.Squad;
import models.Hero;
import java.util.List;

public interface SquadDao {
    //LIST
    List<Squad> getAll();

    //CREATE
    static void add(Squad squad) {

    }

    //READ
    static Squad findById(int id) {
        return null;
    }

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllCategories();
}
