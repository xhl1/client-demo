package com.example.clientdemo.config;

import com.mdl.common.config.MdlMyBatisConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig extends MdlMyBatisConfig {
    @Override
    protected String getTypeAliasesPackage() {
        return "com.example.clientdemo.entity";
    }

    @Override
    protected String getMapperLocations() {
//        return "com/user/mapper/*.xml";
        return "";
    }

    @Override
    protected String getBasePackage() {
        return "com.example.clientdemo.dao";
    }
}
