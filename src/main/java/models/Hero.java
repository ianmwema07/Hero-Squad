package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private static int id;
    private String name;
    private int age;
    private String special_power;
    private String weakness;
    private int squadId;
    public Hero(String name, int age, String special_power, String weakness,int id,int squadId) {
        this.name = name;
        this.age = age;
        this.special_power = special_power;
        this.weakness = weakness;
        this.id = id;
        this.squadId = squadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return getName() == hero.getName()  &&
                Objects.equals(getName(), hero.getName()) &&
                Objects.equals(getSquadId(), hero.getSquadId());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(),getWeakness(),getSpecial_power(), getSquadId());
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

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public static int getId() {
        return id;
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
