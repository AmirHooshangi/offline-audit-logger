package com.zoha.batch.writer;


import com.zoha.batch.entity.pstn.StandarLogPstnEntity;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by velorin on 5/13/16.
 */
public class PSTNItemWriter implements ItemWriter<StandarLogPstnEntity> {

    @Override
    public void write(List<? extends StandarLogPstnEntity> list) throws Exception {
        System.out.println("daram minevisam");
        System.out.println(list);
    }
}
