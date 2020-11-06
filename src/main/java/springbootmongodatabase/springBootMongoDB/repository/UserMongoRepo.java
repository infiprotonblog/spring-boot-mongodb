package springbootmongodatabase.springBootMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springbootmongodatabase.springBootMongoDB.model.User;

public interface UserMongoRepo extends MongoRepository<User, Integer> {
}
