# User Registration Module using Spring Boot + Spring MVC + Spring Security + Hibernate 5 + Thymeleaf + MySQL

http://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html

 # User Registration Module

We are using :
Spring Boot 2, 
Spring MVC, 
Spring Security, 
Hibernate 5, 
Thymeleaf and 
MySQL.

We validate the user registration fields with hibernate validator annotations and a custom field matching validator to validate if the email and/or password fields match. We will create Role-based Spring security with a MySQL database.

We will develop two main functionalities:

1. Register user (stored data into MySQL database).
2. Login Authentication - validate user login credentials with database email and password.

 # Security Dependencies

        <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity4</artifactId>
        </dependency>
        
# Spring Security Configuration

We secure our application using Spring Security Form Authentication using the following configuration. Make sure you permit all access to the /registration page and your static resources.

        protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                "/registration**",
                "/js/**",
                "/css/**",
                "/img/**",
                "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }
    
# Database Create SQL Scripts

As we specified spring.jpa.hibernate.ddl-auto = update property will auto create tables in MySQL database. The below are create statements of three tables.

        CREATE TABLE `role` (
        `id` bigint(20) NOT NULL,
        `name` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

        CREATE TABLE `user` (
        `id` bigint(20) NOT NULL,
        `email` varchar(255) DEFAULT NULL,
        `first_name` varchar(255) DEFAULT NULL,
         `last_name` varchar(255) DEFAULT NULL,
         `password` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`id`),
         UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


        CREATE TABLE `users_roles` (
        `user_id` bigint(20) NOT NULL,
         `role_id` bigint(20) NOT NULL,
        KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
         KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
        CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
         CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; 
        
 # Spring Rest Controller - UserRegistrationController.java
 
This controller is mapped to “/registration” URI. We use the UserRegistrationDto to process and validate the user registration form and inject it using the @ModelAttribute("user") annotation. When the form is submitted it’s automatically validated and errors are available in the BindingResult. Next, we check if a user doesn’t already exist with the submitted email. If the form has any errors, we return to the registration page. Otherwise, we redirect and inform the user the registration procedure is complete.

# Data Transfer Object - UserRegistrationDto.java

We use the UserRegistrationDto to validate the user registration form. This DTO is annotated using Hibernate-Validation annotations which validate trivial fields on empty and our own custom @FieldMatch annotations which validates if the password is equal to the confirm password and the email address field is equal to the confirm email address field.

# Creating Field Matching Validator

We created a special @FieldMatch annotation to support the validation process of comparing fields with each other if they match. We can input two fields first and second and an optional message.

Next, we create a custom validator by implementing the ConstraintValidator. Here we can validate if the given input fields match. If they do we return true if the fields don’t match we return false.

# Demo

Registration page demo
Access http://localhost:8080/registration and fill in some invalid fields.


