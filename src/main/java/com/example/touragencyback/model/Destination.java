package com.example.touragencyback.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "destination")
    private List<TourPackage> tourPackages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination", orphanRemoval = true)
    private List<DestinationImage> destinationImages;
}
