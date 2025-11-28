package main.java.com.airtribe.studentmanagement.entity;

public abstract  class Person {

    protected String name;
    protected int age;
    String city;
    private String id;


    public Person(){
        this.id = "";
        this.name = "";
        this.age = 0;
        this.city = "";
        System.out.println("Person default constructor called");
    }


    public Person(String id, String name, int age, String city){
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        System.out.println("parameterized constructor called");
    }


    public Person(Person other) {
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
        this.city = other.city;
        System.out.println("Person copy constructor called");
    }


     public String getId(){
        return id;
     }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 1) {
            this.age = age;
        }
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
            this.city = city;
    }

    public abstract void displayInfo();
    public abstract String getRole();

    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + city + '\'' +
                '}';
    }

}
