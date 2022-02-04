package com.example.webmaintapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "version",
    uniqueConstraints = @UniqueConstraint(name = "unique_version_component",
        columnNames = {"version_number", "component_id"}))
@Getter
@Setter
@NoArgsConstructor
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "version_number", nullable = false)
    @NotEmpty
    private String versionNumber;

    @ManyToOne
    private Component component;

    public Version(String versionNumber, Component component) {
        this.versionNumber = versionNumber;
        this.component = component;
    }

}
