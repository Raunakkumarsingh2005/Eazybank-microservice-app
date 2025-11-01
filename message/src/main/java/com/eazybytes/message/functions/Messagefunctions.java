package com.eazybytes.message.functions;

import com.eazybytes.message.MessageApplication;
import com.eazybytes.message.dto.AccountsMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Messagefunctions {

    private static final Logger logger = LoggerFactory.getLogger(MessageApplication.class);

    @Bean
    public Function<AccountsMsgDto,AccountsMsgDto> email() {
        return accountsMsgDto -> {
            logger.info("Sending email with details : {}", accountsMsgDto.toString());
            return accountsMsgDto;
        };
    }

    @Bean
    public Function<AccountsMsgDto,Long> sms() {
        return accountsMsgDto -> {
            logger.info("Sending sms with details : {}", accountsMsgDto.toString());
            return accountsMsgDto.accountsNumber();
        };
    }
}
