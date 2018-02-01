package messages;

public class MessageConsumerProducerTest {
    public static void main(String[] args) {
        MessageProducer producerThread = new MessageProducer("messages");
        System.out.println("starting MessageProducer");
        producerThread.start();

        MessageConsumer consumerThread = new MessageConsumer("messages");
        System.out.println("starting MessageConsumer");
        consumerThread.start();

    }
}