package models;

import java.util.List;
import java.util.Objects;

public class Squad {
    private int max_size;
    private String name;
    private String cause;
    private int id;

    List<Hero> getAllHeroesBy(int squad_id) {
        return null;
    }

    public Squad(int max_size, String name, String cause) {
        this.max_size = max_size;
        this.name = name;
        this.cause = cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Squad)) return false;
        Squad squad = (Squad) o;
        return getName() == squad.getName() && id == squad.id
                && Objects.equals(getName(), squad.getName())
                && Objects.equals(getCause(), squad.getCause());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(),getCause(),getmax_size());
    }
    public int getmax_size() {
        return max_size;
    }

    public void setmax_size(int max_size) {
        this.max_size = max_size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
