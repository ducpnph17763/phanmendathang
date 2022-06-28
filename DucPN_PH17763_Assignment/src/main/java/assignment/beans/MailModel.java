package assignment.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {
	String from = "Duc";
	String to;
	String sub;
	String body;
}
