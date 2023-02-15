package cn.itcast.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "cn.itcast")
@Configuration // 标识当前类是一个配置类，作用：代替XML配置文件
public class SpringConfig {
}
