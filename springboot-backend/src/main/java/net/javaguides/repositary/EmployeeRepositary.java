package net.javaguides.repositary;

import net.javaguides.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepositary extends JpaRepository<Employee,Long> {
}
