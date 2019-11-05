package lvat.SpringBoot_SpringSecurity.accessingdatamysql.repository;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {
}
