package org.jaka.configure;

import java.util.Properties;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.jaka.ConsumerClient;

@WebListener
public class JakaServletContextListener implements ServletContextListener {

  @Resource
  private ManagedExecutorService managedExecutorService;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    String bootstrapServers = "kafka1:9092";
    String groupId = "my-fourth-application";
    String topic = "demo_java";

    Properties properties = new Properties();
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    ConsumerClient consumerClient = new ConsumerClient(properties, topic);
    managedExecutorService.submit(consumerClient);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
      // Shutdown the executor service when the context is destroyed
        if (managedExecutorService != null) {
          managedExecutorService.shutdown();
      }    
  }
}
