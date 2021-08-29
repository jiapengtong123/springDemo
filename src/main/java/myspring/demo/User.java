package myspring.demo;

import myspring.annotations.Autowired;
import myspring.annotations.Component;
import myspring.annotations.Qualifier;
import myspring.annotations.Value;

@Component()
public class User {

    @Value("Rod")
    private String name;

    @Value("21")
    private Integer age;

    @Autowired
    @Qualifier("myPet")
    private Pet pet;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
