import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.HeroDao;
import dao.Sql2oHeroDao;
import models.Hero;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
    staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

    //get: delete all heroes
        get("/heroes/delete",(req,res) -> {
            Map<String, Object> model = new HashMap<>();
            HeroDao.clearAllHeroes();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    //get: delete an individual task
        get("/heroes/:id/delete",(req, res)->{
           Map<String, Object> model = new HashMap<>();
            int idOfHeroToBeDeleted = Integer.parseInt(req.params("id"));
            HeroDao.deleteById(idOfHeroToBeDeleted);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show all tasks
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = (ArrayList<Hero>) HeroDao.getAll(); //change
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new task form
        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());


        //task: process new task form
        post("/heroes", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String special_power = req.queryParams("special_power");
            String weakness = req.queryParams("weakness");

            Hero newHero = new Hero(name,age,special_power,weakness); //change
            heroDao.add(newHero);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show an individual task
        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params("id"));
            int foundHero = HeroDao.findById(idOfHeroToFind); //change
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a task
        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            int editHero = HeroDao.findById(idOfHeroToEdit); //change
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());


        //task: process a form to update a task
        post("/heroes/:id", App::handle, new HandlebarsTemplateEngine());


    }

    private static ModelAndView handle(Request req, Response res) { //URL to update task on POST route
        Map<String, Object> model = new HashMap<>();
        String newHero = req.queryParams("name");
        int idOfHeroToEdit = Integer.parseInt(req.params("id"));
        int editHero = HeroDao.findById(idOfHeroToEdit); //change
        HeroDao.update(newHero); //change
        res.redirect("/");
        return null;
    }
}
