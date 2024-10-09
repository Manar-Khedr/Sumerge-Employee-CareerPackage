package org.example.Mappers;

public class OtherContributionsTypeDTO {

    private int id;
    private String description;

    public OtherContributionsTypeDTO(){}

    public OtherContributionsTypeDTO(String description) {
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
