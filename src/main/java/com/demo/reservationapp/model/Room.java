package com.demo.reservationapp.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="rooms")
@EntityListeners(AuditingEntityListener.class)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "room_avialable")
    private boolean roomAvialable;

    @NotBlank
    @Column(name = "room_name")
    private String roomName;

    @NotBlank
    @Column(name = "room_price")
    private Integer roomPrice;

    @NotBlank
    @Column(name = "bed_number")
    private Integer bedNumber;

    @NotBlank
    @Column(name = "single_bed_number")
    private Integer singleBedNumber;

    @NotBlank
    @Column(name = "double_bed_number")
    private Integer doubleBedNumber;

    @NotBlank
    @Column(name = "location_city")
    private String locationCity;

    @NotBlank
    @Column(name = "location_street")
    private String locationStreet;

    public Room() {
        super();
    }

    public Room(Long id, boolean roomAvialable, String roomName, Integer roomPrice, Integer bedNumber,
                Integer singleBedNumber, Integer doubleBedNumber, String locationCity, String locationStreet) {
        super();
        this.id = id;
        this.roomAvialable = roomAvialable;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.bedNumber = bedNumber;
        this.singleBedNumber = singleBedNumber;
        this.doubleBedNumber = doubleBedNumber;
        this.locationCity = locationCity;
        this.locationStreet = locationStreet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRoomAvialable() {
        return roomAvialable;
    }

    public void setRoomAvialable(boolean roomAvialable) {
        this.roomAvialable = roomAvialable;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getSingleBedNumber() {
        return singleBedNumber;
    }

    public void setSingleBedNumber(Integer singleBedNumber) {
        this.singleBedNumber = singleBedNumber;
    }

    public Integer getDoubleBedNumber() {
        return doubleBedNumber;
    }

    public void setDoubleBedNumber(Integer doubleBedNumber) {
        this.doubleBedNumber = doubleBedNumber;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationStreet() {
        return locationStreet;
    }

    public void setLocationStreet(String locationStreet) {
        this.locationStreet = locationStreet;
    }
}
