package buzzmonitor.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import buzzmonitor.model.Post;
import buzzmonitor.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.GET)
	 public ResponseEntity<List<Post>> getAllPosts(@RequestParam Map<String, String> params) {
		return new ResponseEntity<List<Post>>(postService.findAllPost(params), HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	 public ResponseEntity<Post> getPost(@PathVariable("id") String id) {
		
		Optional<Post> post = postService.findByPostId(id);
		
		if (!post.isPresent()) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		} 
		
		return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
		
		if (postService.findByPostId(post.getPost_id()).isPresent()) {
			return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.OK);
		}
		
		return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<?> deletePost(@PathVariable("id") String id) {
		postService.deletePostById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }		 
}