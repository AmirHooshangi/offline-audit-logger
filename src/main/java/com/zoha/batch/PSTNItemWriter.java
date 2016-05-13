package com.zoha.batch;


import org.springframework.batch.item.ItemWriter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by velorin on 5/13/16.
 */
public class PSTNItemWriter implements ItemWriter<ZohaModel> {

    @Override
    public void write(List<? extends ZohaModel> list) throws Exception {
        System.out.println("daram minevisam");
        System.out.println(list);
    }
}
