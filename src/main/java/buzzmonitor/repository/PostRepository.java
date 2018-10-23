package buzzmonitor.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import buzzmonitor.model.Post;

public interface PostRepository extends ElasticsearchRepository<Post, String> {

}
