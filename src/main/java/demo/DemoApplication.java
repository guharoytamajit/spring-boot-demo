package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@SpringBootApplication
@Import(value = { ScheduleConfig.class, AsyncConfig.class })
@EnableSwagger2
@EnableTransactionManagement
@EnableCaching
@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket docket() {
		Predicate<String> paths = PathSelectors.ant("/**");

		ApiInfo apiInfo = new ApiInfoBuilder().title("Welcome")
				.description("The Spring Boot sample project")
				.contact("guharoytamajit@gmail.com").version("1.0.0").build();

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo).select().paths(paths).build();

		return docket;
	}

	@Bean
	public CacheManager cachemanager() {
		// this is a var args constructor where we need to pass all cache names
		return new ConcurrentMapCacheManager("empCache1", "empCache2");
	}
}
