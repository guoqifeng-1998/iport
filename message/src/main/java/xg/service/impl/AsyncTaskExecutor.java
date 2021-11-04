package xg.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import xg.beans.Alarm;
import xg.beans.Msg;
import xg.beans.Sensor;
import xg.beans.SensorModel;
import xg.cfg.SensorService;
import xg.utils.AjaxResult;

import java.util.List;
import java.util.Random;

@Component
public class AsyncTaskExecutor {
    @Autowired
    SensorService ss;
    @Autowired
    KafkaTemplate<String,Alarm> tmp;
    @Async
    public void executor() {
        AjaxResult<PageInfo<Sensor>> rs=ss.getAllSensors();
        System.out.println(rs.getObj());
        PageInfo mp = rs.getObj();
        List<Sensor> list=(List)mp.getList();
        Random r = new Random();
        while (true) {
            list.forEach(s->{
                try {
                    Thread.sleep(r.nextInt(20000));
                } catch (InterruptedException e) {
                }
                Msg m=new Msg();
                m.setSensor(s);
                m.setCurrentValue(r.nextInt(100));
                parseMsg(m);
            });
        }
    }

    void parseMsg(Msg m){
        SensorModel sm=m.getSensor().getSensorModel();
        int low=sm.getLowThreshold();
        int hi=sm.getHighThreshold();
        int cur=m.getCurrentValue();
        Alarm alrm=new Alarm();
        alrm.setSensor(m.getSensor());
        alrm.setCurrentValue(m.getCurrentValue());
        String msg=sm.getDeviceType()+":";
        String temp;
        if(cur<low){
            temp="当前值太低";
        }else if(cur>hi){
            temp="当前值太高";
        }else {
            temp="正常";
            alrm.setNormal(true);
        }
        alrm.setAlarmMsg(msg+temp);
        tmp.send("alarm",alrm);
    }
}