package kg.atractor.control9.service.impl;

import kg.atractor.control9.model.User;
import kg.atractor.control9.repository.UserRepository;
import kg.atractor.control9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean passportExists(String passportNumber) {
        return userRepository.existsByPassportNumber(passportNumber);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByLibraryCardNumber(String libraryCardNumber) {
        return userRepository.findByLibraryCardNumber(libraryCardNumber);
    }

    @Override
    public User findById(Long userId) {
        userRepository.findById(userId);
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
