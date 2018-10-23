package buzzmonitor.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import buzzmonitor.model.Post;
import buzzmonitor.repository.PostRepository;

@Service
public class PostService {
	
	private final String SORT_PARAM = "sort";
	private final String ORD_PARAM = "ord";
	private final String PAGE_INDEX_PARAM = "pageIndex";
	private final String PAGE_SIZE_PARAM = "pageSize";
	private final String DEFAULT_SORT = "date";
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
		
	public List<Post> findAllPost(Map<String, String> params) {
		FieldSortBuilder fieldSortBuilder = createSortQueryWithParams(params);
		PageRequest pageRequest = createPageableWithParams(params);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withSort(fieldSortBuilder)
				.withPageable(pageRequest)
				.withQuery(createBoolQueryWithParams(params))
				.build();
	
		return elasticsearchTemplate.queryForList(searchQuery, Post.class);
	}
	
	public Optional<Post> findByPostId(String id) {
		return repository.findById(id);
	}
	
	public Post savePost(Post post) {
		return repository.save(post);
	}
	
	public void deletePostById(String id) {
		repository.deleteById(id);
	}
	
	private BoolQueryBuilder createBoolQueryWithParams(Map<String, String> params) {
		BoolQueryBuilder query = QueryBuilders.boolQuery();
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			 query.must(QueryBuilders.matchQuery(entry.getKey(), entry.getValue())); 
		}
		
		return query;
	}
	
	private FieldSortBuilder createSortQueryWithParams(Map<String, String> params) {
		String newSort = params.get(SORT_PARAM) == null ? DEFAULT_SORT: params.get(SORT_PARAM);
		SortOrder newOrd = params.get(ORD_PARAM) != null && params.get(ORD_PARAM).equals(SortOrder.DESC.toString()) ? SortOrder.DESC: SortOrder.ASC;
		params.remove(SORT_PARAM);
		params.remove(ORD_PARAM);
		
		return new FieldSortBuilder(newSort).order(newOrd);
	}
	
	private PageRequest createPageableWithParams(Map<String, String> params) {
		int indexPage = params.get(PAGE_INDEX_PARAM) == null ? 0:Integer.parseInt(params.get(PAGE_INDEX_PARAM));
		int sizePage = params.get(PAGE_SIZE_PARAM) == null ? 20:Integer.parseInt(params.get(PAGE_SIZE_PARAM));
		params.remove(PAGE_INDEX_PARAM);
		params.remove(PAGE_SIZE_PARAM);
		
		return PageRequest.of(indexPage, sizePage);
	}
}
