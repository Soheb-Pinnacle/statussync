// package com.org.Account.ScheduleMessage;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class ScheduledMessageService {

//     // private final ScheduledMessageRepository repository;
//     // private final SimpMessagingTemplate messagingTemplate;

//     // @Autowired
//     // public ScheduledMessageService(ScheduledMessageRepository repository,SimpMessagingTemplate messagingTemplate) {
//     //     this.repository = repository;
//     //     this.messagingTemplate = messagingTemplate;
//     // }

//     // // ✅ Runs every 10 seconds and fetches messages scheduled BEFORE now
//     // @Scheduled(fixedRate = 10000)  
//     // public void checkAndSendMessages() {
//     //     LocalDateTime now = LocalDateTime.now();  // ✅ Correct variable usage
        
//     //     // ✅ Fetch messages scheduled BEFORE the current time and not yet sent
//     //     List<ScheduledMessage> messages = repository.findByScheduledTimeBeforeAndSentFalse(now);

//     //     for (ScheduledMessage message : messages) {
//     //         sendMessageToUser(message.getMessage());  // ✅ Send message
//     //         message.setSent(true);  // ✅ Mark as sent
//     //         repository.save(message);  // ✅ Update in DB

//     //         // Notify frontend using WebSocket
//     //         messagingTemplate.convertAndSend("/topic/messages", message);

//     //     }
//     // }

//     // private void sendMessageToUser(String message) {
//     //     System.out.println("📩 Sending message: " + message);  // Simulated message sending
//     // }

//     // // ✅ Save a new scheduled message
//     // public ScheduledMessage scheduleMessage(ScheduledMessage request) {
//     //     request.setSent(false);  // Ensure sent is initialized
//     //     return repository.save(request);
//     // }

//     // // ✅ Retrieve all scheduled messages
//     // public List<ScheduledMessage> getAllScheduledMessages() {
//     //     return repository.findAll();
//     // }

//     // // ✅ Retrieve a scheduled message by ID
//     // public ScheduledMessage getScheduledMessageById(Long id) {
//     //     return repository.findById(id).orElse(null);
//     // }

//     private final ScheduledMessageRepository repository;
//     private final SimpMessagingTemplate messagingTemplate;

//     @Autowired
//     public ScheduledMessageService(ScheduledMessageRepository repository, SimpMessagingTemplate messagingTemplate) {
//         this.repository = repository;
//         this.messagingTemplate = messagingTemplate;
//     }

//     // ✅ Runs every 10 seconds to check messages
//     @Scheduled(fixedRate = 10000)
//     public void checkAndSendMessages() {
//         LocalDateTime now = LocalDateTime.now();  

//         // ✅ Fetch messages that are scheduled before now and not yet sent
//         List<ScheduledMessage> messages = repository.findByScheduledTimeBeforeAndSentFalse(now);

//         for (ScheduledMessage message : messages) {
//             sendMessageToUser(message.getMessage());  // ✅ Simulated message sending
//             message.setSent(true);  // ✅ Mark as sent
//             repository.save(message);  // ✅ Update in DB

//             // ✅ Notify frontend using WebSocket
//             messagingTemplate.convertAndSend("/topic/messages", message);
//         }
//     }

//     private void sendMessageToUser(String message) {
//         System.out.println("📩 Sending message: " + message);  // Simulated sending
//     }

//     public ScheduledMessage scheduleMessage(ScheduledMessage request) {
//         request.setSent(false);
//         return repository.save(request);
//     }

//     public List<ScheduledMessage> getAllScheduledMessages() {
//         return repository.findAll();
//     }

//     public ScheduledMessage getScheduledMessageById(Long id) {
//         return repository.findById(id).orElse(null);
//     }



// }


// package com.org.Account.ScheduleMessage;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class ScheduledMessageService {

//     private final ScheduledMessageRepository repository;
//     private final SimpMessagingTemplate messagingTemplate;

//     @Autowired
//     public ScheduledMessageService(ScheduledMessageRepository repository, SimpMessagingTemplate messagingTemplate) {
//         this.repository = repository;
//         this.messagingTemplate = messagingTemplate;
//     }

//     // ✅ Runs every 10 seconds to check for scheduled messages
//     @Scheduled(fixedRate = 10000)
//     public void checkAndSendMessages() {
//         LocalDateTime now = LocalDateTime.now();
        
//         // ✅ Find all messages that need to be sent
//         List<ScheduledMessage> messages = repository.findByScheduledTimeBeforeAndSentFalse(now);

//         for (ScheduledMessage message : messages) {
//             sendMessageToUser(message.getMessage());  // Simulated sending
//             message.setSent(true);  // ✅ Mark as sent
//             repository.save(message);  // ✅ Update in DB

//             // ✅ Notify frontend via WebSocket
//             messagingTemplate.convertAndSend("/topic/messages", message);
//         }
//     }

//     private void sendMessageToUser(String message) {
//         System.out.println("📩 Sending message: " + message);  // Simulate sending message
//     }

//     public ScheduledMessage scheduleMessage(ScheduledMessage request) {
//         request.setSent(false);
//         return repository.save(request);
//     }

//     public List<ScheduledMessage> getAllScheduledMessages() {
//         return repository.findAll();
//     }
// }

package com.org.Account.ScheduleMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduledMessageService {

    private final ScheduledMessageRepository repository;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ScheduledMessageService(ScheduledMessageRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    // ✅ Runs every 10 seconds to check for due messages
    @Scheduled(fixedRate = 10000)
    @Transactional
    public void checkAndSendMessages() {
        LocalDateTime now = LocalDateTime.now();

        // ✅ Fetch messages that are due (scheduledTime <= now) and not yet sent
        List<ScheduledMessage> messages = repository.findByScheduledTimeBeforeAndSentFalse(now);

        for (ScheduledMessage message : messages) {
            sendMessageToUser(message.getMessage());  // Simulated sending
            message.setSent(true);  // ✅ Mark as sent
            repository.save(message);  // ✅ Update in DB

            // ✅ Notify frontend via WebSocket
            messagingTemplate.convertAndSend("/topic/messages", message);
        }
    }

    private void sendMessageToUser(String message) {
        System.out.println("📩 Sending message: " + message);  // Simulate sending message
    }

    public ScheduledMessage scheduleMessage(ScheduledMessage request) {
        request.setSent(false);
        return repository.save(request);
    }

    public List<ScheduledMessage> getAllScheduledMessages() {
        return repository.findAll();
    }
}
