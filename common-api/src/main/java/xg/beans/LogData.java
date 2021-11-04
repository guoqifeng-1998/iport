package xg.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogData {
    Integer id;
    String username;
    String operType;
    String moduleName;
    boolean result;
    Date operTime;
    String operContent;

    public LogData(String username, String operType, String moduleName, boolean result, String operContent) {
        this.username = username;
        this.operType = operType;
        this.moduleName = moduleName;
        this.result = result;
        this.operContent = operContent;
    }
}
