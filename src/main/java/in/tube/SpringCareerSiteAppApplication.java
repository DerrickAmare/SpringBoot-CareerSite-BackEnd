package in.tube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringCareerSiteAppApplication {

	@Bean	
 Docket createDocket() {
		
		return new Docket (DocumentationType.SWAGGER_2).// UI Screen type
				select(). // to specify RestControllers
				apis(RequestHandlerSelectors.basePackage("in.tube.restcontroller"))// base packages for// RestController
				.build()// build the docket object
				.useDefaultResponseMessages(false).apiInfo(getApiInfo());
	}
	
	@Bean
 ApiInfo getApiInfo() {
		final ApiInfoBuilder builder= new ApiInfoBuilder();
	return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCareerSiteAppApplication.class, args);
	}

}
