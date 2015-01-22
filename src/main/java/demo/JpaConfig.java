package demo;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"demo.repository"})
@EntityScan(basePackages = {"demo.jpa"})
public class JpaConfig {
}
