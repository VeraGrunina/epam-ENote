package generalPackage.config.repositories;

import generalPackage.config.model.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashRepository extends JpaRepository<Hash, Long> {
}
