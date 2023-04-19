package co.develhope.NoSqlOrm.repositories;

import co.develhope.NoSqlOrm.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
