package com.example.oauth.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.oauth.oauthserver.config.PersistenceConfiguration;


@SpringBootApplication
@Import(value={PersistenceConfiguration.class})
public class OauthServerApplication  {

//	@Autowired
//    private ApplicationContext context;
//
//    @Bean
//    public ServletRegistrationBean restApi() {
//        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
//        applicationContext.setParent(context);
//        applicationContext.setConfigLocation("classpath:/META-INF/rest.xml");
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        dispatcherServlet.setApplicationContext(applicationContext);
//
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
//        servletRegistrationBean.setName("restApi");
//
//        return servletRegistrationBean;
//    }
    
	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
