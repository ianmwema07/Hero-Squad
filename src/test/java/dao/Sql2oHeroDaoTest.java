package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oHeroDaoTest {


    private Sql2oHeroDao  heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "","");
        heroDao =  new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void addingCourseSetsAge() throws Exception {
        Hero hero = new Hero("BatMan",43,"rich","Ego",1,1);
        int originalHeroAge = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroAge, hero.getId()); //how does this work?
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = new Hero("BatMan",43,"rich","Ego",1,1);
        HeroDao.add(hero); //add to dao (takes care of saving)
        Hero foundHero = HeroDao.findById(Hero.getId()); //retrieve
        assertEquals(hero, foundHero); //should be the same
    }
}
