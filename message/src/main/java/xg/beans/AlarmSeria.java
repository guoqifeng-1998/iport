package xg.beans;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Serializer;

public class AlarmSeria implements Serializer<Alarm> {
    @Override
    public byte[] serialize(String s, Alarm o) {
        System.out.println("s=" + s + ",o=" + o);
        return JSON.toJSONBytes(o);
    }
}
