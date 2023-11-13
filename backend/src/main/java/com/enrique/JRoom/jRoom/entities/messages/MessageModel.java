package com.enrique.JRoom.jRoom.entities.messages;

public class MessageModel {


    private Long id;
    private String messageContent;
    private Long senderId;
    private Long chatRoomId;
    private LocalDateTime createdAt;
    private LocalDateTime readAt;
    private boolean isRead;

    
}
