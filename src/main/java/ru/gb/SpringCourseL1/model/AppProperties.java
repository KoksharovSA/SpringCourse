package ru.gb.SpringCourseL1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "app")
@ConfigurationPropertiesScan
@Data
@AllArgsConstructor
public class AppProperties {
    private String findAll;
    private String getUserById;
    private String save;
    private String deleteById;
    private String updateUser;
}
