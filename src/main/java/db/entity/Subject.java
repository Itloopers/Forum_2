package db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="getSubByName",query="select sub from Subject sub where name like :subname")
@NamedQuery(name="getSubById",query="select sub from Subject sub where id=:id")
public class Subject {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private int numberOfPosts;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccount subjectAuthor;

	@OneToMany(mappedBy = "subject")
	private List<Post> postsList;

	public Subject() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPosts() {
		return numberOfPosts;
	}

	public void setNumberOfPosts(int numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}

	public List<Post> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}

	public UserAccount getSubjectAuthor() {
		return subjectAuthor;
	}

	public void setSubjectAuthor(UserAccount subjectAuthor) {
		this.subjectAuthor = subjectAuthor;
	}

}
