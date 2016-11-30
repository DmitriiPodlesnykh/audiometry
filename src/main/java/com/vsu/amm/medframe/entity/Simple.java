package com.vsu.amm.medframe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Simples")
public class Simple {
    @Id
    private Long id;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public Simple(){

    }

    public Simple(Long id){
        this.id = id;
    }
}
