package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "other_contributions_requirement"
)
public class OtherContributionsRequirement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    // career package id

}
