package co.edu.iudigital.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuracion de Swagger
 * @author carlos
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean  
	public Docket ApiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(
						RequestHandlerSelectors.basePackage("co.edu.iudigital.app.controller")
				)
				.paths(PathSelectors.any())
				.build()
				.apiInfo(ApiInfo.DEFAULT);
	}
    private ApiInfo apiInfo() {
    	return new ApiInfo(
    			"Api de HelpMe",
    			"Api para la App HelpMe",
    			"1.0",
    			"htpps://iudigital.edu.co",
    			new Contact(
    					"carlos velez",
    					"https://iudigital.edu.co",
    					"carlos.velez@est.iudigital.edu.co"),
    			"Apache 2.0",
    			"https://www.apache.org/licenses/LICENSE-2.ohtml",
    			Collections.emptyList()
    			);
    }
}
