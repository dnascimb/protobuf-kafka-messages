package kafka.serializer;

import com.protobuf.Schema.Message;
import org.apache.kafka.common.serialization.Serializer;

public class MessageSerializer extends Adapter implements Serializer<Message> {
    @Override
    public byte[] serialize(final String topic, final Message data) {
        return data.toByteArray();
    }
}