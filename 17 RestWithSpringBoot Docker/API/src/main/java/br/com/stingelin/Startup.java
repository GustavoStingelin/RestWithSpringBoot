package br.com.stingelin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.stingelin.config.FileStorageConfig;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageConfig.class
})
@EnableAutoConfiguration
@ComponentScan
public class Startup {
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);

		// BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		// String result = bCryptPasswordEncoder.encode("Admin123");
		// System.out.println("My hash " + result);
	}
}
