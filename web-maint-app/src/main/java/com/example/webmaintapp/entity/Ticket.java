package com.example.webmaintapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false, length = 80)
    @NotEmpty
    @Size(min = 3, max = 80)
    private String title;

    private String description;

    @Enumerated(value = EnumType.ORDINAL)
    @NotNull
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_ticket_customer_id"), nullable = false)
    @NotNull
    private Customer customer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "version_id", foreignKey = @ForeignKey(name = "fk_ticket_version_id"))
//    private Version version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", foreignKey = @ForeignKey(name = "fk_ticket_component_id"), nullable = false)
    private Component component;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", length = 20)
    @NotNull
    private Status status;

}
