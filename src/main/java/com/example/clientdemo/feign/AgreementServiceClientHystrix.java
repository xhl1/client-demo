package com.example.clientdemo.feign;

import com.example.clientdemo2.entity.Agreement;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AgreementServiceClientHystrix
 * @Package com.example.clientdemo.service
 * @Description:
 * @Date 2018/6/1下午 2:19
 */
@Component
public class AgreementServiceClientHystrix implements AgreementServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(AgreementServiceClientHystrix.class);

    @Override
    public void mqConsume(@Param("id") Long id) {
        logger.info("mqConsume fallback {}", id);
    }

    @Override
    public Agreement findAgreement(Agreement agreement) {
        logger.info("失败");
        return null;
    }
}
