package com.enrique.JRoom.jRoom.entities.chatRoom;

import java.time.LocalDateTime;

import com.enrique.JRoom.jRoom.entities.appuser.AppUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode

@Entity
public class ChatRoom {


    @SequenceGenerator(
        name = "room_id_seq",
        sequenceName = "room_id_seq",
        allocationSize = 1
    )
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "room_id_seq"
    )
    private Long id;
    private String name;
    private String description;
    private ChatRoomType type;
    private AppUser createdBy;
    private LocalDateTime createdAt;
    private RoomCode code; 
    private Long userCount;

    
}
