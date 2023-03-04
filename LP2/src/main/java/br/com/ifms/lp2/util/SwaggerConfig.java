package br.com.ifms.lp2.util;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	
	@Bean

	public Docket api() {
		return new
		Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(null);
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
		.title("API da Unidade <b> Curricular Lingaguem de programação 2 </br>")
		.description("Essa é a API de Avaliação de Estudantes")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
		.termsOfServiceUrl("/service.html")
		.version("1.0.0").contact(new Contact("Marcio Teixeira Oliveira","http://www.ifms.edu.br/","marcio.oliveira@ifms.edu.br"))
		.build();
		return apiInfo;
	}

}

