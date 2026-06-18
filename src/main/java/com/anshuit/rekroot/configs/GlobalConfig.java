package com.anshuit.rekroot.configs;

import com.anshuit.rekroot.dtos.CompanyDto;
import com.anshuit.rekroot.dtos.JobDto;
import com.anshuit.rekroot.entities.Company;
import com.anshuit.rekroot.entities.Job;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class GlobalConfig {
    @Bean
    @Description("ModelMapper bean")
    ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

    @Bean(name = "auditorAware")
    AuditorAware auditorAware() {
        return new AuditorAwareImpl();
    }
}
