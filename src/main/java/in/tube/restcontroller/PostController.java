package in.tube.restcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tube.model.Post;
import in.tube.repository.PostRepository;
import in.tube.repository.SearchRepositoryImpl;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PostController{
	
	@Autowired
	private PostRepository repo;
	
	@Autowired
	private SearchRepositoryImpl srepo;
	
	@ApiIgnore
@RequestMapping(value="/")
public void redirect(HttpServletResponse response) throws IOException{
	response.sendRedirect("/swagger-ui.html");
	
}
	
	@GetMapping("/post")
	public List<Post> getAllPosts(){
		return repo.findAll();
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		
		return repo.save(post);
		
	}
	@GetMapping("/posts/{text}")
	List<Post> search(@PathVariable String text){
		
		return srepo.finByText(text);
	}
}
