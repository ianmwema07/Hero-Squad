package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
public class Sql2oHeroDaoTest {


    private Sql2oHeroDao  heroDao;

    @Before

//    public void setUp() throws Exception{
////        String connectionString = "jdbc:postgresql://ec2-54-164-40-66.compute-1.amazonaws.com:5432/d114ip9s55jkjm"; // connect to postgres test database
////        Sql2o sql2o = new Sql2o(connectionString, "khzdzzcxzedfet", "1ada44be26a7f93fb69669afd44a51aaa3f245fb3ec6648e8db995708d893251");
////        heroDao =  new Sql2oHeroDao(sql2o);
////        conn = sql2o.open();
//    }

//    @After
//    public void tearDown() throws Exception{
////        conn.close();
//    }

    @Test
    public void addingCourseSetsAge() throws Exception {
        Hero hero = new Hero("BatMan",43,"rich","Ego",0);
        int originalHeroAge = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroAge, hero.getId()); //how does this work?
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = new Hero("BatMan",43,"rich","Ego",1);
        HeroDao.add(hero); //add to dao (takes care of saving)
        Hero foundHero = HeroDao.findById(Hero.getId()); //retrieve
        assertEquals(hero, foundHero); //should be the same
    }
}
