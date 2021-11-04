package xg.beans;

import lombok.Data;

@Data
public class Sensor {
    Integer id;
    String sensorName;
    String sensorCode;
    String protocal;
    SensorModel sensorModel; //传感器模型
    Item item;
}
