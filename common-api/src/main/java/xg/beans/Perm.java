package xg.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class Perm implements Serializable {
    Integer id;
    String name;
    String ext;
}
