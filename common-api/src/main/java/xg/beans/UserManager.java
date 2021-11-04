package xg.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserManager implements Serializable {
    Integer id;
    String username;
    String password="123";
    String salt;
    String phone;
    List<Role> roles;
    Orga o;
}
