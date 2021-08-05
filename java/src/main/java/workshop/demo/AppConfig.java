package workshop.demo;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class AppConfig {

	@Bean(name="instanceName")
	@Scope("singleton")
	public String instanceName() {
		return getConfig("INSTANCE_NAME");
	}

	@Bean(name="instanceHash")
	@Scope("singleton")
	public String instanceHash() {
		return getConfig("INSTANCE_HASH");
	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return (logger);
	}

	private String getConfig(final String name) {
		final Optional<String> opt = Optional.ofNullable(System.getenv(name));
		if (opt.isPresent())
			return (opt.get());
		return ("");
	}
}
