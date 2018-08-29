package com.esb.sample.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "com.esb.sample" })
@EnableConfigurationProperties
public class Application extends SpringBootServletInitializer {
	
	private static final Logger APP_LOGGER = LoggerFactory.getLogger(Application.class);
	
	//logback.xml properties
	private static final String KEY_LOG_HOME = "LOG_HOME";
	private static final String DEFAULT_LOG_HOME = "${HOME}/logs";
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationPidFileWriter("app.pid"));
		setupDefaultLogProperties();
		application.run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	private static void setupDefaultLogProperties() {
		if (APP_LOGGER.isDebugEnabled()) {
			APP_LOGGER.debug("Initializing logback properties");
		}

		String logHome = System.getProperty("LOG_HOME");

		if (logHome != null && APP_LOGGER.isDebugEnabled()) {
			APP_LOGGER.debug("LOG_HOME parameter : " + logHome);
		} else {
			if (APP_LOGGER.isDebugEnabled()) {
				APP_LOGGER.debug("LOG_HOME parameter does not exist, setting to default : " + DEFAULT_LOG_HOME);
			}
			System.setProperty(KEY_LOG_HOME, DEFAULT_LOG_HOME);
		}
	}
}
