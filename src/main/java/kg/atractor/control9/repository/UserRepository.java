package kg.atractor.control9.repository;

import kg.atractor.control9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPassportNumber(String passportNumber);

    User findByLibraryCardNumber(String libraryCardNumber);
}
