package ru.gb.SpringCourseL1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.gb.SpringCourseL1.model.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

}
