package com.enrique.JRoom.jRoom.entities.chatRoom;

import java.time.LocalDateTime;
import java.util.List;

import com.enrique.JRoom.jRoom.entities.appuser.AppUser;
import com.enrique.JRoom.jRoom.entities.messages.MessageModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "chat_room")
public class ChatRoom {

    private static final int CODE_LENGTH = 5;

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;


    @Column(name = "room_name")
    private String name;

    @Column(name = "room_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private ChatRoomType type;

    @ManyToOne
    @JoinColumn(name = "room_created_by")
    private AppUser createdBy;

    @Column(name = "room_created_at")
    private LocalDateTime createdAt;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "room_messages")
    private List<MessageModel> roomMessages;

    @Column(name = "room_users")
    private List<AppUser> roomUsers;

    

    public ChatRoom(String name, 
                    String description, 
                    ChatRoomType type, 
                    AppUser createdBy, 
                    LocalDateTime createdAt,
                    List<MessageModel> roomMessages,
                    List<AppUser> roomUsers) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.roomCode = RoomCode.generateUniqueCode(CODE_LENGTH);
        this.roomMessages = roomMessages;
        this.roomUsers = roomUsers;
    }

    
}
