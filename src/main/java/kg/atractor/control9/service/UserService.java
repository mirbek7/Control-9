package kg.atractor.control9.service;

import kg.atractor.control9.model.User;

public interface UserService {
    boolean passportExists(String passportNumber);
    void save(User user);

    User findByLibraryCardNumber(String libraryCardNumber);

    User findById(Long userId);
}
