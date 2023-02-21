package com.MI8.MI8.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 512)
    private String RoomDescription;

    @OneToOne(mappedBy = "currentRoom")
    @JsonIgnore
    private Game game;

    @Column
    private List<Integer> nextRoomIds;

    public Room(String roomDescription) {
        RoomDescription = roomDescription;
        this.nextRoomIds = new ArrayList<>();
    }

    public Room() {
    }

    public List<Integer> getNextRooms() {
        return nextRoomIds;
    }

    public void setNextRooms(List<Integer> nextRooms) {
        this.nextRoomIds = nextRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        RoomDescription = roomDescription;
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}