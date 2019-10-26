package com.zhku.mh.batch_demo.config;

import com.zhku.mh.batch_demo.entities.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class CvsBatchJobConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    DataSource dataSource;

    /*
    * 还有其他两个ItemReader
    * 1、JdbcPagingItemReader：读取数据库中的数据
    * 2、StaxEventItemReader: 读取xml中的数据
    */
    @Bean
    @StepScope
    FlatFileItemReader<User> itemReader() {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>(); //加载普通文件的ItemReader
        reader.setLinesToSkip(1); //跳过第一行
        reader.setResource(new ClassPathResource("data.csv"));
        reader.setLineMapper(new DefaultLineMapper<User>() {{ //设置每一行的数据信息
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("username", "address", "gender"); //配置一共有几列
                setDelimiter("\t"); //通过间隔符进行切分
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                setTargetType(User.class); //映射实体类
            }});
        }});
        return reader;
    }

    /*
    *   配置数据的写出逻辑，还有其他两种的ItemWriter
    *   1、FlatFileItemWriter：将数据写出为一个普通文件
    *   2、StaxEventItemWriter: 将数据写出为XML
    *   3、还有针对不同数据库的ItemWriter
    *       MongoItemWriter、JpaItemWriter、HibernateItemWriter
    *
    */
    @Bean
    JdbcBatchItemWriter jdbcBatchItemWriter() {
        JdbcBatchItemWriter itemWriter = new JdbcBatchItemWriter(); //将数据写出到一个关系型数据库
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO batch_user (username, address, gender) " +
                "VALUES (:username, :address, :gender)"); //占位符用法是  :xxx
        itemWriter.setItemSqlParameterSourceProvider(
                new BeanPropertyItemSqlParameterSourceProvider<>()); //将实体类的属性和占位符一一映射
        return itemWriter;
    }

    @Bean
    Step csvStep(){
        return stepBuilderFactory.get("csvStep")
                .<User,User>chunk(2) //每读取到两条数据就执行一次write操作
                .reader(itemReader())
                .writer(jdbcBatchItemWriter())
                .build();
    }

    @Bean
    Job csvJob(){
        return jobBuilderFactory.get("csvJob")
                .start(csvStep())
                .build();
    }

}
