package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "other_contributions_type"
)
public class OtherContributionsType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    public OtherContributionsType(){}

    public OtherContributionsType(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
