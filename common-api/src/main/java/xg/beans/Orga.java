package xg.beans;

import lombok.Data;

import java.io.Serializable;

//机构类
@Data
public class Orga implements Serializable{
    Integer id;
    String name;
    Orga parentOrga;
    OrgaType orgaType;
    String location;
    String orga_number;
    String ext;
}
