package generalPackage.data.dao;

import generalPackage.data.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookDAO extends JpaRepository<Notebook, Long> {
}
