package com.shafi.practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shafi.practice.model.Posts;


@Repository
@Transactional
public interface PostsRepository extends JpaRepository<Posts, Long> {

	List<Posts> findByUser_userId(Long id);
}
