package com.example.clientdemo.feign;

import com.example.clientdemo2.entity.Agreement;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: AgreementServiceClient
 * @Package com.example.clientdemo.service
 * @Description:
 * @Date 2018/6/1下午 2:16
 */
@Component
@FeignClient(name = "config-rms", fallback = AgreementServiceClientHystrix.class)
public interface AgreementServiceClient {
    @PostMapping(value = "/mq/consume/{id}")
    void mqConsume(@PathVariable("id") Long id);

    @PostMapping("/feign/get/find")
    Agreement findAgreement(@RequestBody Agreement agreement);
}
