package xg.beans;

import lombok.Data;

import java.util.List;

@Data
public class Scene {
    Integer id;
    String sceneNumber;
    String sceneName;
    String alarmTitle;
    String alarmMsg;
    Orga o;
    List<Rule> rules;
}
