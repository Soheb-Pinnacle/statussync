// package com.org.Account.ScheduleMessage;



// import org.springframework.http.ResponseEntity;
// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// @RestController
// @RequestMapping("/api/messages")
// @CrossOrigin(origins = "http://localhost:5173") // Adjust if frontend runs on a different port
// public class ScheduledMessageController {

    
//     private final ScheduledMessageService messageService;

//     @Autowired
//     public ScheduledMessageController(ScheduledMessageService messageService) {
//         this.messageService = messageService;
//     }

//     // ✅ POST - Schedule a message
//     @PostMapping("/schedule")
//     public ResponseEntity<ScheduledMessage> scheduleMessage(@RequestBody ScheduledMessage request) {
//         ScheduledMessage savedMessage = messageService.scheduleMessage(request);
//         return ResponseEntity.ok(savedMessage);
//     }

//     // ✅ GET - Retrieve all scheduled messages
//     @GetMapping("/all")
//     public ResponseEntity<List<ScheduledMessage>> getAllMessages() {
//         return ResponseEntity.ok(messageService.getAllScheduledMessages());
//     }

//     // ✅ GET - Retrieve a single scheduled message by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<ScheduledMessage> getScheduledMessageById(@PathVariable Long id) {
//         ScheduledMessage message = messageService.getScheduledMessageById(id);
//         return message != null ? ResponseEntity.ok(message) : ResponseEntity.notFound().build();
//     }
//     // WebSocket endpoint for real-time messages
//     @MessageMapping("/sendMessage")
//     @SendTo("/topic/messages")
//     public ScheduledMessage sendMessage(ScheduledMessage message) {
//         return message;
        
//     }
// }

package com.org.Account.ScheduleMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:5173")  // ✅ Allow frontend access
public class ScheduledMessageController {

    private final ScheduledMessageService service;

    @Autowired
    public ScheduledMessageController(ScheduledMessageService service) {
        this.service = service;
    }

    // ✅ POST: Schedule a message
    @PostMapping("/schedule")
    public ScheduledMessage scheduleMessage(@RequestBody ScheduledMessage request) {
        return service.scheduleMessage(request);
    }

    // ✅ GET: Retrieve all scheduled messages
    @GetMapping("/all")
    public List<ScheduledMessage> getAllScheduledMessages() {
        return service.getAllScheduledMessages();
    }
}
