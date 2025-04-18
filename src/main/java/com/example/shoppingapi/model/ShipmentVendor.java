package com.example.shoppingapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_vendor")
@Data
public class ShipmentVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name", length = 255, nullable = false)
    private String vendorName;

    @Column(name = "vendor_contact", length = 255)
    private String vendorContact;

    @Column(name = "vendor_email", length = 255, unique = true)
    private String vendorEmail;

    @Column(name = "official_website_url", columnDefinition = "TEXT")
    private String officialWebsiteUrl;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (createdAt == null) {
            createdAt = now;
        }
        if (updatedAt == null) {
            updatedAt = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
