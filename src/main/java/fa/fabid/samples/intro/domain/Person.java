package fa.fabid.samples.intro.domain;

public class Person {
    private int id;
    private String fName;
    private String lName;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        if (!fName.equals(person.fName)) return false;
        return lName.equals(person.lName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fName.hashCode();
        result = 31 * result + lName.hashCode();
        result = 31 * result + age;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
