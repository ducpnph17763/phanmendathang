package assignment.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@NotBlank
	private String name;

	@NotBlank
	private String image;

	@NotBlank
	private String price;

	@NotBlank
	private String created_date;

	@NotNull
	@Max(1)
	@Min(0)
	private String available;

	@NotBlank
	private int category_id;
}
