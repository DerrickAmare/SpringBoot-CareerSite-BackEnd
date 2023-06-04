package in.tube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.tube.model.Post;

public interface PostRepository extends MongoRepository<Post,String> {

}
