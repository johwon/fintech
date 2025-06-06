package com.zerobase.com.zerobase.kafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.zerobase.com.zerobase.kafka.enum.KafkaTopic
import com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LoanRequestSender (
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestDto: LoanRequestDto){
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestDto))

    }
}