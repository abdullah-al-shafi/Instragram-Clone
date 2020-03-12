package com.shafi.practice.service;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shafi.practice.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
//	@Autowired
//	Reaction
//	
//	public void addComment(String comment) {
//		
//		
//	}
//	
//    public long addNewLike(long postId, long userId) {
//        var session = hibernateConfig.getSession();
//        var transaction = session.getTransaction();
//
//        if (!transaction.isActive()){
//            transaction = session.beginTransaction();
//        }
//
//        Like like = new Like();
//
//        Post post = new Post();
//        post.setId(postId);
//        User user = new User();
//        user.setId(userId);
//
//        like.setPost(post);
//        like.setWoner(user);
//
//        long likeId = 0;
//        try{
//            likeId = (long) session.save(like);
//         transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (transaction!= null){
//                transaction.rollback();
//            }
//        }finally {
//            session.close();
//        }
//
//        return likeId;
//    }
//
//    public boolean isAlreadyLiked(long postId, long userId) {
//
//        var session = hibernateConfig.getSession();
//        var transaction = session.getTransaction();
//
//        if (!transaction.isActive()){
//            transaction = session.beginTransaction();
//        }
//
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Like> likeCQ = cb.createQuery(Like.class);
//        Root<Like> root = likeCQ.from(Like.class);
//
//        likeCQ.where(cb.and(cb.equal(root.get("post"), postId),cb.equal(root.get("woner"), userId)));
//
//
//
//        var query = session.createQuery(likeCQ);
//
//
//        var likeList = new ArrayList<Like>();
//
//        try {
//            likeList = (ArrayList<Like>) query.getResultList();
//            transaction.commit();
//
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//
//       if (likeList.size() <= 0){
//           return false;
//       }else {
//           return true;
//       }
//
//    }
//
//    @Transactional
//    public long removeLike(long postId, long userId) {
//
//        var session = hibernateConfig.getSession();
//        var transaction = session.getTransaction();
//
//        if (!transaction.isActive()){
//            transaction = session.beginTransaction();
//        }
//
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<Like> criteriaDelete = cb.createCriteriaDelete(Like.class);
//        Root<Like> root = criteriaDelete.from(Like.class);
//
//        Post post = new Post();
//        post.setId(postId);
//        criteriaDelete.where(cb.and(cb.equal(root.get("post"), postId),cb.equal(root.get("woner"), userId)));
//
//
//        var query = session.createQuery(criteriaDelete);
//
//        long val = 0;
//
//        try {
//            val = query.executeUpdate();
//            transaction.commit();
//
//        }catch (HibernateException e){
//
//            e.printStackTrace();
//            if (transaction != null){
//                transaction.rollback();
//            }
//        }finally {
//            session.close();
//        }
//
//        return val;
//
//    }
}
