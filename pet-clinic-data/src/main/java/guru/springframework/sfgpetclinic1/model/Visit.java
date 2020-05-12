package guru.springframework.sfgpetclinic1.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{
    private LocalDate date;
    private String description;
    private Pet pet;


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
