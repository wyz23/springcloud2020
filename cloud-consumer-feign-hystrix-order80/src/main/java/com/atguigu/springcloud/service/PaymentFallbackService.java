package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

//服务降级总类，直接在实现的接口PaymentHystrixService上加fallback;@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
//如果调用的服务CLOUD-PROVIDER-HYSTRIX-PAYMENT宕机了，会走以下兜底服务降级的类
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fallback paymentInfo_OK /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fallback paymentInfo_TimeOut /(ㄒoㄒ)/~~";
    }
}
