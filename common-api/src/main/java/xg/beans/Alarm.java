package xg.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Alarm {
    Integer id;
    Sensor sensor;
    Integer currentValue;
    String alarmMsg;
    boolean normal;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    Date alarmTime;
    boolean isHandled;
}
