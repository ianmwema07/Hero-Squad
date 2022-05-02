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
        Hero hero = new Hero("BatMan",43,"rich","Ego");
        int originalHeroAge = hero.getAge();
        heroDao.add(hero);
        assertNotEquals(originalHeroAge, hero.getAge()); //how does this work?
    }
}
