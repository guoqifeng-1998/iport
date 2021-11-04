package xg.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Item {
    Integer id;
    String name;
    String number;
    Orga o;
    String addr;
    String phone;
    Date createTime;
}
