package generalPackage.data.dao;

import generalPackage.data.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditDAO extends JpaRepository<Credit, Integer> {
}
