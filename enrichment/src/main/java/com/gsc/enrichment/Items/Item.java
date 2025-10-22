package com.gsc.enrichment.Items;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastLocation;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    private LocalDateTime lastCheckedInAt;

    @Column(nullable = false)
    private LocalDateTime lastCheckedOutAt;

    private String imagePath;

    Item() {

    }

    Item(String name, String lastLocation, boolean isAvailable, LocalDateTime lastCheckedInAt, LocalDateTime lastCheckedOutAt, String imagePath) {
        this.name = name;
        this.lastLocation = lastLocation;
        this.isAvailable = isAvailable;
        this.lastCheckedInAt = lastCheckedInAt;
        this.lastCheckedOutAt = lastCheckedOutAt;
        this.imagePath = imagePath;
    }

    Item(Long id, String name, String lastLocation, boolean isAvailable, LocalDateTime lastCheckedInAt, LocalDateTime lastCheckedOutAt, String imagePath) {
        this.id = id;
        this.name = name;
        this.lastLocation = lastLocation;
        this.isAvailable = isAvailable;
        this.lastCheckedInAt = lastCheckedInAt;
        this.lastCheckedOutAt = lastCheckedOutAt;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }
    public Long setId(Long id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public String setLastLocation(String lastLocation) {
        return this.lastLocation = lastLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean setAvailable(boolean isAvailable) {
        return this.isAvailable = isAvailable;
    }

    public LocalDateTime getLastCheckedInAt() {
        return lastCheckedInAt;
    }

    public LocalDateTime setLastCheckedInAt(LocalDateTime lastCheckedInAt) {
        return this.lastCheckedInAt = lastCheckedInAt;
    }

    public LocalDateTime getLastCheckedOutAt() {
        return lastCheckedOutAt;
    }

    public LocalDateTime setLastCheckedOutAt(LocalDateTime lastCheckedOutAt) {
        return this.lastCheckedOutAt = lastCheckedOutAt;
    }

    public String getImagePath() {
        return imagePath;
    }
    public String setImagePath(String imagePath) {
        return this.imagePath = imagePath;
    }



}
