package dao;

import models.Hero;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oHeroDao implements HeroDao{
    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    public void add(Hero hero) {
        String sql = "INSERT INTO heroes (name, age, special_power, weakness, squad_id ) VALUE(:name, :age, :special_power, :weakness, :squadId)";
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(hero) //map my argument onto the query, so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            hero.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops! we have an error!
        }
    }


    public List<Hero> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes") //raw sql
                    .executeAndFetch(Hero.class); //fetch a list
        }
    }




    public Hero findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Hero.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String name) {

    }




    @Override
    public void update(int id, String name, int age, String newSpecialPower, String weakness, int squad_id){
        String sql = "UPDATE heroes SET (special_power, squadId) = (:special_power,:squad_id) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("special_power", newSpecialPower)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }


    public void deleteById(int id) {
        String sql = "DELETE from heroes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    public void clearAllHeroes() {
        String sql = "DELETE from heroes";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
