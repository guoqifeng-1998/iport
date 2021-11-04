package xg.cfg;

import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import xg.beans.Sensor;
import xg.utils.AjaxResult;

@Component
@FeignClient("asset-manager")
public interface SensorService {
    @GetMapping("/asset/sensor")
    AjaxResult<PageInfo<Sensor>> getAllSensors();
}