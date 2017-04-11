package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2  // Springfoxを使用可能にするためのアノテーション
public class AppConfig {

    @Bean
    public Docket document() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("^/(?!error).*$"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

//    private Predicate<String> paths() {
//        return or(containsPattern("/api*"));  //APIのエントリポイントを正規表現で指定
//    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Sample API", "",
                "terms of service", "", "", "", "");
        return apiInfo;
    }
}