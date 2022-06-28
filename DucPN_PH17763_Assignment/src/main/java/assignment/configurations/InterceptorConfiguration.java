package assignment.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import assignment.interceptors.DangNhapInterceptors;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	@Autowired
	private DangNhapInterceptors Interceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(Interceptors).addPathPatterns("/giohang").addPathPatterns("/user/**")
				.addPathPatterns("/admin/**").excludePathPatterns("/login", "/register", "/trangchu");
	}
}
