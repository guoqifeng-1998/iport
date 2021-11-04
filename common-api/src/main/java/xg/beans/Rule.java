package xg.beans;

import lombok.Data;

@Data
public class Rule {
    Integer id;
    String operLogic;
    String dataPointName;
    Integer highValue;
    Integer lowValue;
    Integer scene_id;
}
