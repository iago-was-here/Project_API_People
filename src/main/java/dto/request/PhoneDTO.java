package dto.request;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	
	private String number;
}
