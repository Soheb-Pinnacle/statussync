package com.org.Account.ScheduleMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduledMessageRepository extends JpaRepository<ScheduledMessage, Long> {
    List<ScheduledMessage> findByScheduledTimeBeforeAndSentFalse(LocalDateTime scheduledTime);
}
