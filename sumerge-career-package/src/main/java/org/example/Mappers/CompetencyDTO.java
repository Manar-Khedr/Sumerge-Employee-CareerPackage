package org.example.Mappers;

import org.example.Enums.CompetencyType;

public class CompetencyDTO {

    private int id;
    private String title;
    private String definition;
    private CompetencyType type;

    public CompetencyDTO(){}

    public CompetencyDTO(String title, String definition, CompetencyType type) {
        this.title = title;
        this.definition = definition;
        this.type = type;
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
