package xg.beans;

import lombok.Data;

import java.util.Date;

@Data
public class SensorModel {
    Integer id;
    String deviceName;
    String deviceType;
    String deviceNumber;
    Date createTime;
    String protocol;
    Integer upInterval;
    String dataPointName;
    String dataPointExtra;
    Integer lowThreshold;
    Integer highThreshold;
}
