package main.java.edu.upc.eetac.dsa;

import java.util.Date;
import java.util.List;

public class Company {

    private String name;
    private String description;

    public Company(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
