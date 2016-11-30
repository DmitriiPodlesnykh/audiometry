package com.vsu.amm.medframe.entity;


import javax.persistence.*;

@Entity
@Table(name = "MED_TESTS")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
}
