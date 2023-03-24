package com.github.aveek22

import org.apache.kafka.clients.consumer.{Consumer, ConsumerConfig, ConsumerRecords, KafkaConsumer}

import java.time.Duration
import java.util.{Collections, Properties}
import collection.convert.ImplicitConversionsToScala.`iterable AsScalaIterable`

object Consumer {

  def main(args: Array[String]): Unit = {

    val consumerProps = new Properties()
    consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv("PS_PROD"))
    consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    consumerProps.put("value.deserializer", "com.github.aveek22.TemptationEventDeserializer")
    consumerProps.put("group.id", "scala-consumer-app")

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