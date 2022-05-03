package dao;

import junit.framework.TestCase;
import models.Hero;
import models.Squad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oSquadDaoTest extends TestCase {

    private Sql2oSquadDao  squadDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "","");
        squadDao = (Sql2oSquadDao) new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception{
        conn.close();
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