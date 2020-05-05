package br.com.gft.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.workshopmongo.domain.Post;
import br.com.gft.workshopmongo.repository.PostRepository;
import br.com.gft.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}

}
