package lvat.SpringBoot_SpringSecurity.accessingdatamysql.repository;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
