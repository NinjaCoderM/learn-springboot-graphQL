package at.codecrafters.learn_springboot_graphql.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;


@Configuration
public class ScalarConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
       return wiringBuilder -> wiringBuilder
               .scalar(graphql.scalars.ExtendedScalars.GraphQLLong)
               .scalar(ExtendedScalars.GraphQLBigDecimal);
    }
}
