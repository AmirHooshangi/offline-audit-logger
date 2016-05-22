package com.zoha.batch.fieldmapper.pstn;

import com.zoha.batch.entity.pstn.DevicePstnEntity;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by velorin on 5/13/16.
 */
public class DevicePstnFieldSetMapper implements FieldSetMapper<DevicePstnEntity> {


    @Override
    public DevicePstnEntity mapFieldSet(FieldSet fieldSet) throws BindException {
        DevicePstnEntity devicePstnEntity = new DevicePstnEntity();

        devicePstnEntity.setName(fieldSet.readString("name"));
        devicePstnEntity.setAge(fieldSet.readString("age"));
        devicePstnEntity.setLocation((fieldSet.readString("location")));

        return devicePstnEntity;
    }
}
