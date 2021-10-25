package com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.config;

import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration").permitAll() // Для url "/" разрешаем полный доступ
                .anyRequest().authenticated() // для всех остальных требуется авторизация
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource) // Для того что бы менеджер мог ходить в бд и искать польз и их роли
//                .passwordEncoder(NoOpPasswordEncoder.getInstance()) // шифрует пароли
//                .usersByUsernameQuery("select username, password, active from user where username=?") // Поиск пользователя по имени
//                // Помогает spring-у получить список пользователей с их ролями
//                // Из таблицы user и присоединённой к ней таблице user_role соединённой через поля u.id и ur.user_id выбираем поля u.username и имя роли ur.roles
//                .authoritiesByUsernameQuery("select u.username, ur.roles from user u inner join user_role ur on u.id = ur.user_id where u.username=?");
//    }
}
