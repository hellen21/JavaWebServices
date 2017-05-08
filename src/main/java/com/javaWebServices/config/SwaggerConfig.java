//package com.javaWebServices.config;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//	
//	 @Bean
//	    public Docket newsApi() {
//	        return new Docket(DocumentationType.SWAGGER_2)
////	                .groupName("users")
////	                .apiInfo(apiInfo())
////	                .select()
////	                .paths(regex("/api/users.*"))
////	                .build();
//	        .apiInfo(apiInfo())
//            .select()
//                    .apis(RequestHandlerSelectors.basePackage("com.javaWebServices"))
//            .paths(PathSelectors.any())
//            .build()
//            .pathMapping("/api/*")
//            .useDefaultResponseMessages(false);
//	    }
//	     
//	    private ApiInfo apiInfo() {
//	        return new ApiInfoBuilder()
////	                .title("Spring REST Sample with Swagger")
////	                .description("Spring REST Sample with Swagger")
////	                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
////	                .contact("Niklas Heidloff")
////	                .license("Apache License Version 2.0")
////	                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
////	                .version("2.0")
////	                .build()
//	        .title("Test API")
//            .description("Test API")
//            .version("0.0.10.SNAPSHOT")
//            .termsOfServiceUrl("")
//            .contact("Test company")
//            .license("Public")
//            .licenseUrl("http://example.com/")
//            .build() ;
//	    }
//}
