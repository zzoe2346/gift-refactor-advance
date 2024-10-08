package gift.config;

import gift.interceptor.AuthInterceptor;
import gift.interceptor.MemberIdArgumentResolver;
import gift.service.TokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final TokenService tokenService;

    public WebConfig(AuthInterceptor authInterceptor, TokenService tokenService) {
        this.authInterceptor = authInterceptor;
        this.tokenService = tokenService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/wishes/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/orders/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/points/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MemberIdArgumentResolver(tokenService));
    }

}
