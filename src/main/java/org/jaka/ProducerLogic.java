package org.jaka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import java.util.Properties;

@Dependent
public class ProducerLogic {
    public void execute() {
        Logger logger = LoggerFactory.getLogger(ProducerLogic.class);
        logger.info("This is the info");

        String bootstrapServer = "kafka1:19092";
        String serverDocker = "host.docker.internal:29092";
        String internalServer = "kafka1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverDocker);
        // properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverDocker);
        // properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, internalServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>("demo_java", "hello_world");
        kafkaProducer.send(record);
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
