package com.github.aveek22

import org.apache.kafka.common.serialization.Deserializer

import java.nio.ByteBuffer
import java.util
import java.time.Instant

class TemptationEventDeserializer extends Deserializer[TemptationEvent]{

//    override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = ???

    override def deserialize(topic: String, data: Array[Byte]): TemptationEvent = {

        val eventStr = new String(data, "UTF8")
        val temptationEvent = eventStr
          .replace("\"","")
          .replace(":","")
          .split(",")


        TemptationEvent(
            temptationEvent(0),
            temptationEvent(1),
            temptationEvent(2),
            temptationEvent(3),
            temptationEvent(4),
            temptationEvent(5),
            temptationEvent(6)
        )

    }

//    override def close(): Unit = ???

}
