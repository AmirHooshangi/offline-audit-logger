package com.zoha.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by velorin on 5/13/16.
 */
public class PSTNFieldSetMapper implements FieldSetMapper<PSTNModel> {


    @Override
    public PSTNModel mapFieldSet(FieldSet fieldSet) throws BindException {
        PSTNModel pstnModel = new PSTNModel();

        pstnModel.setName(fieldSet.readString("name"));
        pstnModel.setAge(fieldSet.readString("age"));
        pstnModel.setLocation((fieldSet.readString("location")));

        return pstnModel;
    }
}
