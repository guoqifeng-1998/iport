package xg.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Role implements Serializable{
    Integer id;
    String name;
    String ext;
    List<Perm>perms;
}
