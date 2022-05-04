package dao;

import models.Hero;
import models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class Sql2oSquadDao {

    public Sql2oSquadDao(Sql2o sql2o) {
    }

    Sql2o sql2o = null;

    public List<Hero> getAllHeroesBySquad(int squadId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE squadId = :squadId")
                    .addParameter("squadId", squadId)
                    .executeAndFetch(Hero.class);
        }
    }

    public void add(Squad squad) {
    }

    public Squad findById(int id) {
        return null;
    }

    public List<Squad> getAll() {
        return null;
    }

    public void update(int idOfSquadToEdit, String newName) {
    }

    public void clearAllSquads() {
        String sql = "DELETE from squads";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
