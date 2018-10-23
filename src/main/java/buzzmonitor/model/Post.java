package buzzmonitor.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "posts", shards = 1)
public class Post {
	
	@Id
	private String post_id;
	
	private String interaction_type;
	
	private String content;
	
	private String rt;
	
	private String sentiment;
	
	private String service;
	
	private String collected_from;
	
	private boolean archived;
	
	private Author author;
	
	private List<String> urls;
	
	private String application;
	
	private String origin;
	
	private boolean replied;
	
	private int count;
	
	private String in_reply_to;
	
	private int engagement;
	
	private String language;
	
	private String collected_time;
	
	private String source;
	
	private String date;
	
	private String elasticsearch_id;
	
	private String elasticsearch_routing;
	
	private String picture_full_size;
	
	private List<String> tag;
	
	private String elasticsearch_index;
	
	private String external_id;
	
	private String url;
	
	private String brand;
	
	private Object user;
	
	public Post() {
	}
	
	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getInteraction_type() {
		return interaction_type;
	}

	public void setInteraction_type(String interaction_type) {
		this.interaction_type = interaction_type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCollected_from() {
		return collected_from;
	}

	public void setCollected_from(String collected_from) {
		this.collected_from = collected_from;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public boolean isReplied() {
		return replied;
	}

	public void setReplied(boolean replied) {
		this.replied = replied;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIn_reply_to() {
		return in_reply_to;
	}

	public void setIn_reply_to(String in_reply_to) {
		this.in_reply_to = in_reply_to;
	}

	public int getEngagement() {
		return engagement;
	}

	public void setEngagement(int engagement) {
		this.engagement = engagement;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCollected_time() {
		return collected_time;
	}

	public void setCollected_time(String collected_time) {
		this.collected_time = collected_time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getElasticsearch_id() {
		return elasticsearch_id;
	}

	public void setElasticsearch_id(String elasticsearch_id) {
		this.elasticsearch_id = elasticsearch_id;
	}

	public String getElasticsearch_routing() {
		return elasticsearch_routing;
	}

	public void setElasticsearch_routing(String elasticsearch_routing) {
		this.elasticsearch_routing = elasticsearch_routing;
	}

	public String getPicture_full_size() {
		return picture_full_size;
	}

	public void setPicture_full_size(String picture_full_size) {
		this.picture_full_size = picture_full_size;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getElasticsearch_index() {
		return elasticsearch_index;
	}

	public void setElasticsearch_index(String elasticsearch_index) {
		this.elasticsearch_index = elasticsearch_index;
	}

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", content=" + content + ", rt=" + rt + ", setiment=" + sentiment
				+ ", service=" + service + ", collected_from=" + collected_from + ", archived=" + archived + ", author="
				+ author + ", urls=" + urls + ", application=" + application + ", origin=" + origin + ", replied="
				+ replied + ", count=" + count + ", in_reply_to=" + in_reply_to + ", engagement=" + engagement
				+ ", language=" + language + ", collected_time=" + collected_time + ", source=" + source + ", date="
				+ date + ", elasticsearch_id=" + elasticsearch_id + ", elasticsearch_routing=" + elasticsearch_routing
				+ ", picture_full_size=" + picture_full_size + ", tag=" + tag + ", elasticsearch_index="
				+ elasticsearch_index + ", external_id=" + external_id + ", url=" + url + ", brand=" + brand + ", user="
				+ user + "]";
	}	
}