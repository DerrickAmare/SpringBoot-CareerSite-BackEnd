package in.tube.repository;

import java.util.List;

import in.tube.model.Post;

public interface SearchRepository {

	List<Post> finByText(String text);
}
