package com.zoha.batch.processor;


import com.zoha.batch.entity.pstn.DevicePstnEntity;
import com.zoha.batch.entity.pstn.StandarLogPstnEntity;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by velorin on 5/13/16.
 */
public class PSTNItemProcessor implements ItemProcessor<DevicePstnEntity, StandarLogPstnEntity> {

    @Override
    public StandarLogPstnEntity process(DevicePstnEntity devicePstnEntity) throws Exception {
        StandarLogPstnEntity zohaModel = new StandarLogPstnEntity();
        zohaModel.setName(devicePstnEntity.getName()+"Zohaaa");
        zohaModel.setAge(devicePstnEntity.getAge()+"Zohaaa");
        zohaModel.setLocation(devicePstnEntity.getLocation()+"Zohaaa");
        return zohaModel;
    }
}
