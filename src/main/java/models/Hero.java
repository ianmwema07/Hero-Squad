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
}
