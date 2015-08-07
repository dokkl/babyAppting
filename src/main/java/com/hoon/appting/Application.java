package com.hoon.appting;


import com.hoon.appting.entity.Sosi;
import com.hoon.appting.repository.SosiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

/**
 * Created by hoon on 2015-07-21.
 */
//@EnableScheduling
@EnableJpaRepositories(basePackages = "com.hoon.appting.repository")
@SpringBootApplication
public class Application {
    static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        log.debug("==[Application main method start]==");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).web(false).run(args);

        SosiRepository sosiRepository = context.getBean(SosiRepository.class);
        sosiRepository.save(new Sosi("태연"));
        sosiRepository.save(new Sosi("윤아"));
        sosiRepository.save(new Sosi("수영"));
        sosiRepository.save(new Sosi("효연"));
        sosiRepository.save(new Sosi("유리"));
        sosiRepository.save(new Sosi("티파니"));
        sosiRepository.save(new Sosi("써니"));
        sosiRepository.save(new Sosi("서현"));

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        log.debug("[========= loaded beanName ==============");
        for (String beanName : beanNames) {
            log.debug("beanName ==> " + beanName);
        }
        log.debug("========= loaded beanName ==============]");
    }
}
