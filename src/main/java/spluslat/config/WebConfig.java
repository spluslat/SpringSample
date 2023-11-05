package spluslat.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spluslat.resolver.CommonDataArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CommonDataArgumentResolver commonDataArgumentResolver;

    public WebConfig(CommonDataArgumentResolver customArgumentResolver) {
        this.commonDataArgumentResolver = customArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(commonDataArgumentResolver);
    }
}