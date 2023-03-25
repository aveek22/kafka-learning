package com.github.kafkaexercise

import com.github.kafkaexercise.adapters.EventConsumer
import org.apache.kafka.clients.consumer.{Consumer, ConsumerConfig, ConsumerRecords, KafkaConsumer}


import java.time.Duration
import java.util.{Collections, Properties}
import collection.convert.ImplicitConversionsToScala.`iterable AsScalaIterable`

object App {

  def main(args: Array[String]): Unit = {

    val source = EventConsumer
    source.consume()

  }

}