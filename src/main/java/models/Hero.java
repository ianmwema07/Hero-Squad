package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    public String name;
    public int age;
    public String special_power;
    public String weakness;

    public Hero(String name, int age, String special_power, String weakness) {
        this.name = name;
        this.age = age;
        this.special_power = special_power;
        this.weakness = weakness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecial_power(String special_power) {
        this.special_power = special_power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecial_power() {
        return special_power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setId(int id) {
    }
}
