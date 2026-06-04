package com.project.employeefacing.screening.Integration;


import com.project.employeefacing.screening.ScreeningDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScreeningTopicProducer {

    final KafkaTemplate kafkaTemplate;
    private static final String TOPIC_A_PAYLOAD = "{\"id\":\"%s\"}";
    private static final String TOPIC_B_PAYLOAD = "{\"id\":\"%s\",\"loanAmount\":\"%s\"}";

    public void publish(ScreeningDto screeningDto) {
        sendMessageToTopicA(screeningDto);
        sendMessageToTopicB(screeningDto);

    }

    @Async
    void sendMessageToTopicA(ScreeningDto screeningDto) {
        kafkaTemplate.send("topicA", screeningDto.loanNumber(), TOPIC_A_PAYLOAD.formatted(screeningDto.customerId()));
    }

    @Async
    void sendMessageToTopicB(ScreeningDto screeningDto) {
        kafkaTemplate.send("topicA", screeningDto.loanNumber(), TOPIC_B_PAYLOAD.formatted(screeningDto.customerId(), screeningDto.loanAmount()));
    }
}
