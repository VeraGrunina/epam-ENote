package generalPackage.data.dao;

import generalPackage.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<Note, Integer> {
}
