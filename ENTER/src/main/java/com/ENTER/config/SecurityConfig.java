package com.ENTER.config;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import lombok.AllArgsConstructor;

//이 세개는 시큐리티의 세트이다... 이해가 안되면 그냥 하면 됨...^^
//빈 등록: 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration //빈등록(IoC관리)
@EnableWebSecurity // 시큐리티 필터가 등록이 된다. 
// @EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻.
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    private final UserDetailsService userDetailsService;
//	  private final AuthenticationSuccessHandler formAuthenticationSuccessHandler;
//    private final AuthenticationFailureHandler formAuthenticationFailureHandler;
//    private final DataSource dataSource;
//	  WebMvcConfigurerAdapter 이건 이제 안쓴다.
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http
//			.headers()
//			.xssProtection();
//	        .and()
//	        .contentSecurityPolicy("script-src 'self'");//(CSP)
		
		/* super.configure(http); */
		http.authorizeRequests()
				.mvcMatchers(// 루트와 해당요청에 대해서는 요청을 허용한다.
				"/"
				,"/scrim/*"
				,"/subscription/*"
				,"/img/*"
				,"/img/*/*"
				,"/img_scrim/*"
				,"/img_scrim/*/*"
				,"/team/**"
				,"/calendar/*"
				).permitAll()
				.anyRequest()	// 나머지 경로는 사용자 인증이 된 요청에 대해서만 요청을 허용한다.
				.authenticated();

		// csrf 토큰 비활성화 (테스트 시 걸어두는 게 좋음)
        // TODO 비동기호출(ajax호출시) csrf header에 추가 하고 disable 삭제
        http.csrf().disable();
// 나중에하자
//        // formLogin
//        http.formLogin()
//                .loginPage("/user/login").permitAll() // 로그인폼 변경
//                .loginProcessingUrl("/")
//                .defaultSuccessUrl("/", true)
//                .successHandler(formAuthenticationSuccessHandler)
//                .failureHandler(formAuthenticationFailureHandler)
//        ;
////
//        http.exceptionHandling()
//                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/account/sign_in"))
//                .accessDeniedPage("/denied")
//        ;
////
//        // logout 처리(POST)
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID", "");;
	}

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/resources/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


    //로그인단 만들면쓰자.

	@Bean //IoC가 되요!!!
	// 이 함수가 리턴하는 new BCryptPasswordEncoder(); 이 값을 스프링이 관리한다. 필요할 때마다 가져다 사용하면 된다. 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
		FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
		filterRegistration.setFilter(new XssEscapeServletFilter());
		filterRegistration.setOrder(1);
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}




}
