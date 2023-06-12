package Enoca.demo.business.core.utilities.exception;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ExceptionDetails {

	
	private Map<String, String> validationErrors;
}
