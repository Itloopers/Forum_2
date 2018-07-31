package db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 50)
	private String username;

	@Column(nullable = false, length = 50)
	private String password;

	@Enumerated(EnumType.STRING)
	private UserTitle userTitle;

	@OneToMany(mappedBy = "author")
	private List<Post> postsList;

	@OneToMany(mappedBy = "subjectAuthor")
	private List<Subject> subjectsList;

	public UserAccount() {
		super();
	}

	public UserAccount(String username, String password, UserTitle userTitle) {
		super();
		this.username = username;
		this.password = password;
		this.userTitle = userTitle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTitle getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(UserTitle userTitle) {
		this.userTitle = userTitle;
	}

	public List<Post> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}

	public List<Subject> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subject> subjectsList) {
		this.subjectsList = subjectsList;
	}

}
