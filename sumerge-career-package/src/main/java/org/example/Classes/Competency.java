package org.example.Classes;

import org.example.Enums.CompetencyType;

import javax.persistence.*;

@Entity
@Table(
        name = "competency"
)
public class Competency {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String definition;
    private CompetencyType type;

    public Competency(){}

    public Competency(String title, CompetencyType type, String definition) {
        this.title = title;
        this.type = type;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public CompetencyType getType() {
        return type;
    }

    public void setType(CompetencyType type) {
        this.type = type;
    }
}
