package set;

/**
 * Created by xwz on 8/24/16.
 */
public class Dog {
    private String name;
    private int age;
    private String color;
    private char sex;

    public Dog() {
        super();
    }

    public Dog(String name, int age, String color, char sex) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (age != dog.age) return false;
        if (sex != dog.sex) return false;
        if (!name.equals(dog.name)) return false;
        return color.equals(dog.color);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + color.hashCode();
        result = 31 * result + (int) sex;
        return result;
    }
}
