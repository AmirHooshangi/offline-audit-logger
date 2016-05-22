package com.zoha.batch.job;

import com.zoha.batch.entity.pstn.DevicePstnEntity;
import com.zoha.batch.entity.pstn.StandarLogPstnEntity;
import com.zoha.batch.fieldmapper.pstn.DevicePstnFieldSetMapper;
import com.zoha.batch.processor.PSTNItemProcessor;
import com.zoha.batch.writer.PSTNItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by velorin on 5/13/16.
 */
@Configuration
@EnableBatchProcessing
public class ZohaJob {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    // tag::jobstep[]
    @Bean
    public Job addnewPSTNJob(){
        return jobs.get("addnewPSTNJob")
                //.listener(protocolListener())
                .start(step())
                .build();
    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step")
                .<DevicePstnEntity,StandarLogPstnEntity>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
           /*     .listener(logProcessListener())*/
                .faultTolerant()
                //.skipLimit(10) //default is set to 0
                //.skip(Exception.class)
                .build();
    }


    @Bean
    public LineMapper<DevicePstnEntity> lineMapper() {
        DefaultLineMapper<DevicePstnEntity> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"name", "age", "location"});

        BeanWrapperFieldSetMapper<DevicePstnEntity> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(DevicePstnEntity.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(pstnFieldSetMapper());

        return lineMapper;
    }

    @Bean
    public DevicePstnFieldSetMapper pstnFieldSetMapper() {
        return new DevicePstnFieldSetMapper();
    }

    /** configure the processor related stuff */

    @Bean
    public ItemReader<DevicePstnEntity> reader(){
        FlatFileItemReader<DevicePstnEntity> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);//first line is title definition
        reader.setResource(new ClassPathResource("pstn.txt"));
        reader.setLineMapper(lineMapper());
        return reader;
    }


    @Bean
    public ItemProcessor<DevicePstnEntity, StandarLogPstnEntity> processor() {
        return new PSTNItemProcessor();
    }


    @Bean
    public ItemWriter<StandarLogPstnEntity> writer() {
        return new PSTNItemWriter();
    }


    /*@Bean
    public ProtocolListener protocolListener(){
        return new ProtocolListener();
    }

    @Bean
    public LogProcessListener logProcessListener(){
        return new LogProcessListener();
    }
*/
}
