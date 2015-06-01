package br.com.grafix.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Class to control created at and updated at
 * Created by Rogerio Ferracin on 01/06/2015.
 */
@MappedSuperclass
public class AbstractTimestampModel {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date updated;

    @PrePersist
    protected void onCreate()
    {
        created = new Date();
    }
    @PreUpdate
    protected void onUpdate()
    {
        updated = new Date();
    }

}
