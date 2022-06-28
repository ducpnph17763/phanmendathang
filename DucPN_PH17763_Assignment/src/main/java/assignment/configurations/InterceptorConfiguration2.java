package assignment.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import assignment.interceptors.PhanQuyenInterceptors;

@Configuration
public class InterceptorConfiguration2 implements WebMvcConfigurer {
	@Autowired
	private PhanQuyenInterceptors Interceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(Interceptors).addPathPatterns("/admin/**").excludePathPatterns("/login", "/register",
				"/trangchu");
	}
}
