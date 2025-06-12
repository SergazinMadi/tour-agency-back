package com.example.touragencyback.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.attribute.standard.Destination;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private String currency;
    private int availableSeats;
    private String packageType;
    private String features;
    private boolean archived;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @OneToMany(mappedBy = "tourPackage")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "tourPackage")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "tour_package_images",
            joinColumns = @JoinColumn(name = "tour_package_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> images;
}
