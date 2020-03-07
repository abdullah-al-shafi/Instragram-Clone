package com.shafi.practice.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shafi.practice.dtos.PostsDto;
import com.shafi.practice.model.Posts;
import com.shafi.practice.repositories.PostsRepository;

@Service
public class PostsService {

	@Autowired
	private PostsRepository postsRepository;
	
	public void addPosts(PostsDto p) {
		
		var postsEntity = new Posts();
		
		BeanUtils.copyProperties(p, postsEntity);
		
		postsRepository.save(postsEntity);
	}
	
	public List<Posts> getAllPost(){
		
		return postsRepository.findAll();
	}
	
}
