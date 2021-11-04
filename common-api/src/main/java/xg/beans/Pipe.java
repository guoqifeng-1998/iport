package xg.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Pipe {
    Integer id;
    String productName;
    String productCode;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    Date manuDate;//生产日期
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    Date productDate;//出厂日期
    PipeModel pipeModel; //产品模型
    Item item; //所属项目
    Sensor sensor;
}
