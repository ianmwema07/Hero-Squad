package models;

import java.util.List;
import java.util.Objects;

public class Squad {
    private int maxSize;
    private String name;
    private String cause;

    List<Hero> getAllHeroesBy(int squad_id) {
        return null;
    }

    public Squad(int maxSize, String name, String cause) {
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Squad)) return false;
        Squad squad = (Squad) o;
        return getName() == squad.getName()  &&
                Objects.equals(getName(), squad.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName(), getName(),getCause(),getMaxSize());
    }
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
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
        return 0;
    }
}
