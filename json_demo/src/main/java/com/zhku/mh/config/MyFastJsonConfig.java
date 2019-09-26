package com.zhku.mh.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-09-26 09:45
 */
@Configuration
public class MyFastJsonConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue, //输出Value为Null的数据
                SerializerFeature.PrettyFormat, //json格式化
                SerializerFeature.WriteNullListAsEmpty //空集合输出[]而非null
        );
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }
}
