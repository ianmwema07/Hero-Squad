package dao;

import models.Hero;
import java.util.List;

public interface HeroDao {

    //List of Heroes
    List<Hero> getAll();

    //Create
    void add(Hero hero);

    //Read
    Hero findById(int id);

    void deleteById(int id);

    void clearAllTasks();

    //update
    //void update(int id, String name);

    //DELETE
    // void deleteById(int id);
    //void clearAllHeroes();
}
