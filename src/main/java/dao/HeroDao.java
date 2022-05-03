package dao;

import models.Hero;
import java.util.List;

public interface HeroDao {


    static void update(String newHero) {
    }

    abstract void add(Hero hero);

    // LIST
    static List<Hero> getAll() {
        return null;
    }

    static Hero findById(int id) {


        return null;
    }

    // UPDATE

    // DELETE
    static void deleteById(int id) {
    }

    static void clearAllHeroes() {

    }

}
