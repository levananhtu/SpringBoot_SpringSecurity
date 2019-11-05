package lvat.SpringBoot_SpringSecurity.accessingdatamysql.repository;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    <T> T findByEmployeeNumber(Long employeeNumber, Class<T> type);

    <T> Page<T> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName, Class<T> type, Pageable pageable);

    <T> Page<T> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName, Class<T> type, Pageable pageable);
}
