package xg.beans;

import lombok.Data;

import java.util.Date;

@Data
public class PipeModel {
    Integer id;
    String pipeName;
    String pipeNumber;
    String pipeType;
    String pipeIntroduce;
    String pipePic;
    String pipeManual;
    Date createTime;
}
