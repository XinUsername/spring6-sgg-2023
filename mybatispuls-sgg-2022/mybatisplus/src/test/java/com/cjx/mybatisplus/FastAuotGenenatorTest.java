package com.cjx.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class FastAuotGenenatorTest {
    @Test
    public void testAuto(){
        //mybatisplus代码自动生成器
        FastAutoGenerator.create("jdbc:mysql://10.255.33.101:3306/mybatis_plus?" +
                        "characterEncoding=utf-8&userSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("cauthor") // 设置作者
                        //.enableSwagger() // 开启 swagger 模式
                                    .fileOverride() // 覆盖已生成文件
                                    .outputDir("src/main/java"); // 指定输出目录
                        })
                        .packageConfig(builder -> {
                            builder.parent("com.cjx") // 设置父包名
                                    .moduleName("auto") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "src/main/java"));
                        // 设置mapperXml生成路径
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("user") // 设置需要生成的表名
                                    .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .execute();
    }
}
