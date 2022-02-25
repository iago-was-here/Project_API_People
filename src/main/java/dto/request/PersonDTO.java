package dto.request;

import java.time.LocalDate;
import java.util.List;

import entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String CPF;
	
	private LocalDate bithDate;
	
	private List<Phone> phones;
}
