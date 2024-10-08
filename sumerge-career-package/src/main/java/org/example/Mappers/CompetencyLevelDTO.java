package org.example.Mappers;

public class CompetencyLevelDTO {

    private int id;
    private int level;
    private String description;
    private CompetencyDTO competency;

    public CompetencyLevelDTO(){}

    public CompetencyLevelDTO(String description, CompetencyDTO competency) {
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

    public CompetencyDTO getCompetency() {
        return competency;
    }

    public void setCompetency(CompetencyDTO competency) {
        this.competency = competency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
