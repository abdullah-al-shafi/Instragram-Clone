package com.shafi.practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shafi.practice.model.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long>{

	Reaction findByPosts_postsIdAndReactedUser_userId(Long postsId , Long userId);
	
	List<Reaction> findByPosts_postsId(Long postsId);
}
