package guru.springframework.sfgpetclinic1.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
