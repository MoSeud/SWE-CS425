package edu.mum.cs.lab7ormjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ClassRooms")
@Data
@NoArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long classRoomId;
    private  String buildingName;
    private  String roomNumber;
    @OneToMany(mappedBy = "classRoom")
    private List<Student> students;

    public ClassRoom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }
}
