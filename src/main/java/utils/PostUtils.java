package utils;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import db.entity.Post;
import db.entity.Subject;
import db.entity.UserAccount;

public class PostUtils extends QueryUtils {

	public static void delete(Long postId) {
		Post post;

		em.getTransaction().begin();
		post = em.find(Post.class, postId);
		Subject subject = post.getSubject();
		subject.setNumberOfPosts(subject.getNumberOfPosts() - 1);
		;
		em.remove(post);
		em.persist(subject);
		em.getTransaction().commit();

		// em.getTransaction().rollback();

	}

	public static void create(String subjectName, String content, UserAccount user) {

		Post post = new Post();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("getSubByName");
		query.setParameter("subname", subjectName);
		Subject subject = (Subject) query.getSingleResult();
		post.setAuthor(user);
		post.setContent(content);
		post.setDateTime(LocalDateTime.now());
		post.setSubject(subject);
		subject.setNumberOfPosts(subject.getNumberOfPosts() + 1);
		em.persist(post);
		em.persist(subject);
		em.getTransaction().commit();

	}

	public static List<Post> getPostList(String subjectName) {
		List<Post> resultList;
		TypedQuery<Post> query = null;

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Post> createQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> fromPost = createQuery.from(Post.class);
		Path<String> path = fromPost.get("subject").get("name");
		Path<Object> path2 = fromPost.get("dateTime");
		Order asc = criteriaBuilder.asc(path2);
		createQuery.select(fromPost).where(criteriaBuilder.equal(path, subjectName)).orderBy(asc);
		query = em.createQuery(createQuery);
		try {
			resultList = query.getResultList();
		} catch (Exception e) {
			resultList = null;
			e.printStackTrace();
		}

		return resultList;
	}

}
