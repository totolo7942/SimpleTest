package com.javabydeveloper.spring.config.importannotation.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CrocodleConfig.class, SnakesConfig.class})
public class ReptilesImportConfig {

}
