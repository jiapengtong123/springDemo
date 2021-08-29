package myspring.demo;

import myspring.annotations.Component;
import myspring.annotations.Value;

@Component("myPet")
public class Pet {

    @Value("Tom")
    private String name;

    @Value("cat")
    private String type;

    public Pet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
