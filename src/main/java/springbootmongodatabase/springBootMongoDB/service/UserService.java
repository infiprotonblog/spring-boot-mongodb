package springbootmongodatabase.springBootMongoDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmongodatabase.springBootMongoDB.exceptions.ResourceNotFoundException;
import springbootmongodatabase.springBootMongoDB.model.User;
import springbootmongodatabase.springBootMongoDB.repository.UserMongoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserMongoRepo userMongoRepo;

    public List<User> userList() {
        return userMongoRepo.findAll();
    }

    public Optional<User> user(int id) {
        return userMongoRepo.findById(id);
    }

    public User saveUser(User user) {
        return userMongoRepo.save(user);
    }

    public void deleteUser(int id) {
        userMongoRepo.deleteById(id);
    }

    public User updateUser(User user) throws ResourceNotFoundException {
        Optional<User> userInfo = userMongoRepo.findById(user.getId());
        if (userInfo.isPresent()) {
            return saveUser(user);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
