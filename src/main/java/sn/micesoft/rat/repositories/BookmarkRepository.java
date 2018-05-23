package sn.micesoft.rat.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.micesoft.rat.entities.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);

	Optional<Bookmark> findById(Long bookmarkId);
}
