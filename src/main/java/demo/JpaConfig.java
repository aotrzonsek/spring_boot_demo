package demo;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"demo.repository"})
@EntityScan(basePackages = {"demo.jpa"})
public class JpaConfig {
}
