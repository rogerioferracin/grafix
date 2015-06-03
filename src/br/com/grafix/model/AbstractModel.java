package br.com.grafix.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Abstract Model class
 * Created by Rogerio Ferracin on 29/05/2015.
 */
@MappedSuperclass
public abstract class AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    //Getters & setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @PrePersist
    protected void onCreate()
    {
        created = new Date();
        updated = new Date();
    }
    @PreUpdate
    protected void onUpdate()
    {
        updated = new Date();
    }

}
