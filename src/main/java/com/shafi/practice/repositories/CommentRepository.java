package com.shafi.practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shafi.practice.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByposts_postsId(Long postsId);
}
