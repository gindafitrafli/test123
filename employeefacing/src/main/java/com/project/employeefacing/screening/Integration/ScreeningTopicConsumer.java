package com.project.employeefacing.screening.Integration;

import com.project.employeefacing.screening.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Log4j2
public class ScreeningTopicConsumer {

    final ScreeningRepository screeningRepository;

    @KafkaListener(id = "topicAConsumer", topics = "topicA", groupId = "topicAGroup")
    void topicAListener(@Payload String data,
                        @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                        Acknowledgment ack) {
       log.info("key: {}, data: {}", key, data);
       ack.acknowledge();
       updateScreeningAResult(key, "result a");
    }

    @Transactional
    void updateScreeningAResult(String id, String result){
        screeningRepository.findById(id).ifPresent(screeningModel -> {
            log.info("key {} is exist", id);
            screeningModel.setScreeningA(result);
            screeningRepository.save(screeningModel);
        });
    }

    @KafkaListener(id = "topicBConsumer", topics = "topicB", groupId = "topicBGroup")
    @Transactional
    void topicBListener(@Payload String data,
                        @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                        Acknowledgment ack) {
        log.info("key: {}, data: {}", key, data);
        ack.acknowledge();

        updateScreeningBResult(key, "result b");
    }

    @Transactional
    void updateScreeningBResult(String id, String result){
        screeningRepository.findById(id).ifPresent(screeningModel -> {
            log.info("key {} is exist", id);
            screeningModel.setScreeningA(result);
            screeningRepository.save(screeningModel);
        });
    }

}
