package dao;

import jdk.internal.jimage.BasicImageReader;
import models.Hero;
import models.Squad;
import org.sql2o.Connection;
import org.sql2o.*;
import java.util.List;

public interface Sql2oSquadDao {
    void add(Squad squad);

    Sql2o sql2o = null;




    public default List<Hero> getAllTasksByCategory(int squad_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE squad_id = :squad_id")
                    .addParameter("squad_id", squad_id)
                    .executeAndFetch(Hero.class);
        }
    }
}
