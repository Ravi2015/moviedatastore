package com.example.moviedatastore.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CAST_MEMBER")
public class CastMemberEntity {
    @Id
    private String castMemberName;

    public String getCastMemberName() {
        return castMemberName;
    }

    public void setCastMemberName(String castMemberName) {
        this.castMemberName = castMemberName;
    }
}
