package assignment.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	@NotBlank(message = "Fullname không được để trống")
	private String fullname;

	@NotBlank(message = "Username không được để trống")
	private String username;

	@NotBlank(message = "Password không được để trống")
	@Size(min = 6, max = 200, message = "Pass tối thiểu 6 kí tự")
	private String password;

	@Email
	@Pattern(regexp = "^[\\w-\\.]+@(fpt.edu.vn)", message = "Email phải có đuôi là @fpt.edu.vn")
	private String email;

	private String photo;

	@NotNull
	@Max(1)
	@Min(0)
	private int admin;
}