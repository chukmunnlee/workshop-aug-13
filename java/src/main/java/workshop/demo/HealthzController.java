package workshop.demo;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/healthz") 
public class HealthzController {

	@GetMapping(produces={ MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> healthz() {
		JsonObject result = Json.createObjectBuilder()
			.add("timestamp", (new Date()).getTime())
			.build();
		return ResponseEntity.ok(result.toString());
	}
}
