# Test Spring Boot Apps with JUnit 5

This example shows how to test your Spring Boot apps with JUnit 5. Please read [Test Your Spring Boot Applications with JUnit 5](https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5) to see how this example was created.

**Prerequisites:** [Java 8, 11, or 12](https://adoptopenjdk.net/).

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-spring-boot-junit5-example.git
cd okta-spring-boot-junit5-example
```

### Create an Application in Okta

Log in to your Okta Developer account (or [sign up](https://developer.okta.com/signup/) if you don’t have an account).

1. From the **Applications** page, choose **Add Application**.
2. On the Create New Application page, select **Web**.
3. Give your app a memorable name, then click **Done**.

Copy your issuer (found under **API** > **Authorization Servers**), client ID, and client secret into `src/main/resources/application.properties` as follows:

```properties
okta.oauth2.issuer=https://{yourOktaDomain}/oauth2/default
okta.oauth2.clientId={clientId}
okta.oauth2.clientSecret={clientSecret}
okta.oauth2.scope=openid
```

**NOTE:** The value of `{yourOktaDomain}` should be something like `dev-123456.okta.com`. Make sure you don't include `-admin` in the value!

After modifying this file, your app will be setup as an OAuth 2.0 resource server, protected by Okta. 

See [this repo's blog post](https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5#generate-a-token-to-test-your-spring-boot-application-with-junit-5) to see how to confirm you've configured everything properly.

## Links

This example uses the following open source libraries:

* [JUnit 5](https://junit.org/junit5/)
* [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5), or on the [Okta Developer Forums](https://devforum.okta.com/).

## License

Apache 2.0, see [LICENSE](LICENSE).
