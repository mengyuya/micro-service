package com.asus.orderservice.config;

//TODO 内部不需要安全框架 此类备用

/*import com.asus.orderservice.handler.FailureHandler;
import com.asus.orderservice.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    FailureHandler failureHandler;
    @Autowired
    SuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("delete", "insert", "queryOne", "queryList", "update");
        auth.inMemoryAuthentication().withUser("user").password("123456").authorities("queryList");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .csrf()
                .disable()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/delete").hasAnyAuthority("delete")
                .antMatchers("/insert").hasAnyAuthority("insert")
                .antMatchers("/queryOne").hasAnyAuthority("queryOne")
                .antMatchers("/queryList").hasAnyAuthority("queryList")
                .antMatchers("/update").hasAnyAuthority("update")
                .antMatchers("/login").permitAll()
                .antMatchers("/**")
                .fullyAuthenticated();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}*/
