package org.jaka.kafka;

import java.util.Properties;
import javax.enterprise.context.Dependent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

@Dependent
public class ProducerClient {
    public void execute(String message) {
        String bootstrapServer = "kafka1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>("demo_java", message);
        kafkaProducer.send(record);
        System.out.print(record.value() + ": This is the record sending by producer client according to parameter you add to url.");
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
