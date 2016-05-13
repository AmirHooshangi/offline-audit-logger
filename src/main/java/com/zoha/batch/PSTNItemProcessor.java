package com.zoha.batch;


import org.springframework.batch.item.ItemProcessor;

/**
 * Created by velorin on 5/13/16.
 */
public class PSTNItemProcessor implements ItemProcessor<PSTNModel, ZohaModel> {

    @Override
    public ZohaModel process(PSTNModel pstnModel) throws Exception {
        ZohaModel zohaModel = new ZohaModel();
        zohaModel.setName(pstnModel.getName()+"Zohaaa");
        zohaModel.setAge(pstnModel.getAge()+"Zohaaa");
        zohaModel.setLocation(pstnModel.getLocation()+"Zohaaa");
        return zohaModel;
    }
}
