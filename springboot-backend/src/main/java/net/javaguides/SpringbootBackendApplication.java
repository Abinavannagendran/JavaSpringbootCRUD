package net.javaguides;

import net.javaguides.model.Employee;
import net.javaguides.repositary.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepositary employeeRepositary;
	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setFirstN("Ragu");
		emp.setLastN("nesh");
		emp.setEmail("ragusumi@gmail.com");
		employeeRepositary.save(emp);

		Employee emp1 = new Employee();
		emp1.setFirstN("Dhi");
		emp1.setLastN("leep");
		emp1.setEmail("dhilsona@gmail.com");
		employeeRepositary.save(emp1);
	}
}
