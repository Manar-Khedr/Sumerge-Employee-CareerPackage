package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "competency_level"
)
public class CompetencyLevel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private int level;
    private String description;
    @ManyToOne
    @JoinColumn(name = "competency_id", nullable = false)
    private Competency competency;

    public CompetencyLevel(){}

    public CompetencyLevel(String description, Competency competency) {
        this.description = description;
        this.competency = competency;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Competency getCompetency() {
        return competency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompetency(Competency competency) {
        this.competency = competency;
    }
}
