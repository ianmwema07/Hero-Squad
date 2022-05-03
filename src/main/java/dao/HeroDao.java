package dao;

import models.Hero;
import java.util.List;

public interface HeroDao {

    //List of Heroes
    static List<Hero> getAll() {
        return null;
    }

    //Create
    void add(Hero hero);

    List<Hero> getAll();

    //Read
    static int findById(int id) {
        return 0;
    }

    Hero findById(int id);

    static void deleteById(int id) {
    }

    static void clearAllHeroes() {

    }

    //update
    static void update(String name) {

    }

    void clearAllTasks();

    //DELETE

}
