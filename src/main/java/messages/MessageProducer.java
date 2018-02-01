package messages;

import com.protobuf.Schema.Message;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import kafka.serializer.MessageSerializer;

import org.apache.kafka.common.serialization.IntegerSerializer;

public class MessageProducer extends Thread {
    private final KafkaProducer<Integer, Message> producer;
    private final String topic;

    public MessageProducer(String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("client.id", "MessageProducer");
        producer = new KafkaProducer<>(props, new IntegerSerializer(), new MessageSerializer());
        this.topic = topic;
    }

    public void run() {
        int messageNo = 1;
        //cap number of messages for demo
        while (messageNo <= 10) {

            Message message = Message.newBuilder()
                .setCreatedDatetime(new Date().toString())
                .setUserId("user" + messageNo)
                .setUserGuid(java.util.UUID.randomUUID().toString())
                .setEventData("{ \"event\": \"LOGIN\" }")
                .build()
                ;
            try {
                producer.send(new ProducerRecord<>(topic,
                        messageNo,
                        message)).get();
                System.out.println("Sent message: (" + messageNo + ", " + message.toString() + ")");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            ++messageNo;
        }
    }
}