package com.brasens.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name="Location_Tree")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationTree {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    @JsonIgnore
    private UUID id;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "locationTree", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Asset> childrens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organization;
}