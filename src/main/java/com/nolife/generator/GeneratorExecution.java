package com.nolife.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成mapper和model
 */
public class GeneratorExecution {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorExecution.class);

    public static void generator() {

        List<String> warnings = new ArrayList<String>();
        try {
//      导入配置表mybatis-generator.xml  
            File configFile = new File("src/main/resources/generatorConfig.xml");
//      创建配置解析器
            ConfigurationParser cp = new ConfigurationParser(warnings);
//利用配置解析器创建配置对象
            Configuration config = cp.parseConfiguration(configFile);
//创建一个默认的DefaultShellCallback对象，主要用来处理文件的创建和合并，传入overwrite参数；默认是不支持文件合并的
            DefaultShellCallback dsc = new DefaultShellCallback(true);
//创建一个MyBatisGenerator对象。MyBatisGenerator类是真正用来执行生成动作的类
            MyBatisGenerator mg = new MyBatisGenerator(config, dsc, warnings);
            mg.generate(null);
        } catch (Exception e) {
            logger.error("异常", e);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        GeneratorExecution.generator();
    }

}
