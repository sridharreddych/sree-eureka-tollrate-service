package eureka.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

	int errorcode = 0;
	
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		System.out.println("health check performed . error code is "+ errorcode);
		
		if(errorcode > 4 && errorcode < 8) {
			errorcode++;
			return Health.down().withDetail("Custom Error Code", errorcode).build();
		}
		errorcode++;
		return Health.up().build();
	}

}
