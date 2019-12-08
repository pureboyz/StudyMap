package com.pureboyz.todolist.framework.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pureboyz.todolist.framework.config.interceptor.AuthenticationInterceptor;

/*
 * https://gist.github.com/ghillert/39536f902d7ac0017964
 * http://kamsi76.tistory.com/entry/Spring4-JavaConfig-%EC%84%A4%EC%A0%95-WebInitializerjava
 */
@Configuration
public class FrameworkConfig implements WebMvcConfigurer {

	@Resource(name="AuthenticationInterceptor")
	private AuthenticationInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/*");
//				.excludePathPatterns("/user/**");
	}

}
