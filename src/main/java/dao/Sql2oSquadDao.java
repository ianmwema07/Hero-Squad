package dao;

import models.Hero;
import models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class Sql2oSquadDao implements SquadDao{
    private final Sql2o sql2o;
    public Sql2oSquadDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    public List<Hero> getAllHeroesBySquad(int squad_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE squad_id = :squad_id")
                    .addParameter("squad_id", squad_id)
                    .executeAndFetch(Hero.class);
        }
    }

    @Override
    public void update(int id, String name, String cause, int max_size) {

        String sql = "UPDATE squads SET (name, cause, max_size) = (:name, :cause, :max_size) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("cause", cause)
                    .addParameter("max_size", max_size)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM squads WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    public void add(Squad squad) {
        String sql = "INSERT INTO squads (name, cause, max_size) VALUES (:name, :cause, :max_size)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(squad)
                    .executeUpdate()
                    .getKey();
            squad.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public Squad findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM squads WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Squad.class);
        }
    }

    public List<Squad> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM squads")
                    .executeAndFetch(Squad.class);
        }
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
