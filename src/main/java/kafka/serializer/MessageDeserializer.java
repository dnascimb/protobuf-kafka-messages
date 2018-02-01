package kafka.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.common.serialization.Deserializer;

import com.protobuf.Schema.Message;

public class MessageDeserializer extends Adapter implements Deserializer<Message> {
    private static final Logger LOG = LoggerFactory.getLogger(MessageDeserializer.class);

    @Override
    public Message deserialize(final String topic, byte[] data) {
        try {
            return Message.parseFrom(data);
        } catch (final InvalidProtocolBufferException e) {
            LOG.error("Received unparseable message", e);
            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
        }
    }

}