package com.github.kafkaexercise.adapters

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecords, KafkaConsumer}
import collection.convert.ImplicitConversionsToScala.`iterable AsScalaIterable`

import java.time.Duration
import java.util.{Collections, Properties}

object EventConsumer extends App{

    def consume(): Unit = {

        val consumerProps = new Properties()
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv("PS_PROD"))
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "scala-consumer-app-3")

        val consumer = new KafkaConsumer[String, String](consumerProps)
        val topic = "temptation-events"

        consumer.subscribe(Collections.singletonList(topic))

        while(true){
            val records: ConsumerRecords[String, String] = consumer.poll(Duration.ofMillis(100))
            for (record <- records.records(topic)){
                println(record.value())
            }
        }

    }

}
