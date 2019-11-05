package lvat.SpringBoot_SpringSecurity.accessingdatamysql.repository;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
