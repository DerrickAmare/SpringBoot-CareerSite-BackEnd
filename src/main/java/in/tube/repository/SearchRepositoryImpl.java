package in.tube.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import in.tube.model.Post;

@Component
public class SearchRepositoryImpl implements SearchRepository {
      
	@Autowired
	MongoConverter converter;
	
	@Autowired
	MongoClient mongoClient;

	List<Post> posts=new ArrayList<>();
	@Override
	public List<Post> finByText(String text) {
		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */

	
		MongoDatabase database = mongoClient.getDatabase("DerrickDB");
		MongoCollection<Document> collection = database.getCollection("JobPost");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", text)
		                .append("path", Arrays.asList("techs", "desc", "profile")))), 
		    new Document("$sort", 
		    new Document("id", 1L))));
		
		result.forEach(doc->posts.add(converter.read(Post.class, doc)));
		
		return posts;
	}

}
