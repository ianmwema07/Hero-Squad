package dao;

import models.Hero;
import java.util.List;

public interface HeroDao {
    abstract void add(Hero hero);

    // LIST
    List<Hero> getAll();

    Hero findById(int id);

    // UPDATE
     void update(int id, String name);

    void update(int id, String name, int age, String newSpecialPower, String weakness);

    // DELETE
     void deleteById(int id);
     void clearAllHeroes();

}
