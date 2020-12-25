package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如何替换负载规则，
 * 默认是轮询
 * 1. 自定义规则不能被@ComponentScan扫描的包及子包下，也就是不能和主类在同一个包下；
 * 2. 在主启动类添加@RibbonClient; 如：@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
 * 7中规则：
 * 1) com.netflix.loadbalancer.RoundRobinRule	轮询
 * 2) com.netflix.loadbalancer.RandomRule	    随机
 * 3) com.netflix.loadbalancer.RetryRule        先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试
 * 4) WeightedResponseTimeRule  	            对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
 * 5) BestAvailableRule  	                    会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
 * 6) AvailabilityFilteringRule  	            先过滤掉故障实例，再选择并发较小的实例
 * 7) ZoneAvoidanceRule 	                    默认规则，复合判断server所在区域的性能和server的可用性选择服务器
 */

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule () {
        return new RandomRule(); //定义为随机
    }
}
