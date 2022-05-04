package dao;

import junit.framework.TestCase;
import models.Hero;
import models.Squad;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import dao.Sql2oHeroDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oSquadDaoTest extends TestCase {

    private Sql2oSquadDao  squadDao;
    private static Sql2oHeroDao heroDao;
    private static Connection conn;

    @BeforeClass
    public void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/todolist_test"; // connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, null,null);
        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("Clearing database");
        squadDao.clearAllSquads();
        heroDao.clearAllHeroes();
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();;
        System.out.println("connection closed");
    }

    @Test
    public void addingCourseSetsSize() throws Exception {
        Squad squad = new Squad(6,"Justice League","Fighting Evil");
        int originalMaxSize = squad.getId();
        squadDao.add(squad);
        assertNotEquals(originalMaxSize, squad.getId()); //how does this work?
    }

    @Test
    public void existingSquadsCanBeFoundById() throws Exception {
        Squad squad = new Squad(6,"Justice League","Fighting injustice");
        SquadDao.add(squad); //add to dao (takes care of saving)
        Squad foundSquad = SquadDao.findById(Hero.getId()); //retrieve
        assertEquals(squad, foundSquad); //should be the same
    }

}