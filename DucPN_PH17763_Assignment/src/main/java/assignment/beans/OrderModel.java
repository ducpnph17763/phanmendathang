package assignment.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
	private int id;
	private int userId;
	private LocalDate createDate;
	private String address;
	private int status;
}
