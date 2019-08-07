# User Registration Module using Spring Boot + Spring MVC + Spring Security + Hibernate 5 + Thymeleaf + MySQL
http://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html

#User Registration Module

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

#Security Dependencies

        <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity4</artifactId>
        </dependency>
#Spring Security Configuration
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
 #Spring Rest Controller - UserRegistrationController.java
This controller is mapped to “/registration” URI. We use the UserRegistrationDto to process and validate the user registration form and inject it using the @ModelAttribute("user") annotation. When the form is submitted it’s automatically validated and errors are available in the BindingResult. Next, we check if a user doesn’t already exist with the submitted email. If the form has any errors, we return to the registration page. Otherwise, we redirect and inform the user the registration procedure is complete.

#Data Transfer Object - UserRegistrationDto.java
We use the UserRegistrationDto to validate the user registration form. This DTO is annotated using Hibernate-Validation annotations which validate trivial fields on empty and our own custom @FieldMatch annotations which validates if the password is equal to the confirm password and the email address field is equal to the confirm email address field.

#Creating Field Matching Validator
We created a special @FieldMatch annotation to support the validation process of comparing fields with each other if they match. We can input two fields first and second and an optional message.

Next, we create a custom validator by implementing the ConstraintValidator. Here we can validate if the given input fields match. If they do we return true if the fields don’t match we return false.

Demo
Registration page demo
Access http://localhost:8080/registration and fill in some invalid fields.


