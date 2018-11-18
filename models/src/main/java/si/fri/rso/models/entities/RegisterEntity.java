package si.fri.rso.models.entities;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class RegisterEntity {
    @Id
    @Column(name = "id")
    private String id;

    //@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    //@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){return id;}
}
