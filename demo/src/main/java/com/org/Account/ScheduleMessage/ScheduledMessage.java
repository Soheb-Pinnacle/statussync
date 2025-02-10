package com.org.Account.ScheduleMessage;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ScheduledMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String message;
    private LocalDateTime scheduledTime;
    private boolean sent;

    // ✅ Constructors
    public ScheduledMessage() {}

    public ScheduledMessage(String message, LocalDateTime scheduledTime) {
        this.message = message;
        this.scheduledTime = scheduledTime;
        this.sent = false; // Default to false
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }
    public boolean isSent() { return sent; }
    public void setSent(boolean sent) { this.sent = sent; }
}
