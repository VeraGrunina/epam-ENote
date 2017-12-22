package generalPackage.data.dao;

import generalPackage.data.entity.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashDAO extends JpaRepository<Hash, Long> {
}
