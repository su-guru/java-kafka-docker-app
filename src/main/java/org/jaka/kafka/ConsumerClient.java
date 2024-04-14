package org.jaka.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerClient implements Runnable {
  
  private KafkaConsumer<String, String> consumer;

  public ConsumerClient(Properties properties, String topic) {
    this.consumer = new KafkaConsumer<>(properties);
    consumer.subscribe(Arrays.asList(topic));
  }

  @Override
  public void run() {
    try {
      while (true) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
        records.forEach(record -> {
          System.out.print(record.value() + ": this is the record from producer client");
        });
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      consumer.close();
    }
  }
}
