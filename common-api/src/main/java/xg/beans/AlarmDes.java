package xg.beans;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;

public class AlarmDes implements Deserializer<Alarm> {
    @Override
    public Alarm deserialize(String s, byte[] bytes) {
        return JSON.parseObject(bytes,Alarm.class);
    }
}
