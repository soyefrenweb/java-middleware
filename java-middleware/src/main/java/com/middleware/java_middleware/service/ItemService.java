package com.middleware.java_middleware.service;

import com.middleware.java_middleware.model.Comment;
import com.middleware.java_middleware.repository.CommentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {
    
    private final CommentRepository commentRepository;

    public ItemService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Cacheable(value = "searchResults", key = "#query")
    public List<String> searchItems(String query){
        return List.of("Resultado 1 " + query , "Resultado 2 " + query);
    }

    @Cacheable(value = "itemDetails", key = "#itemId")
    public List<Comment> getItemComments(String itemId){
        return commentRepository.findByItemId(itemId);
    }

    @CacheEvict(value = "itemDetails", key = "#comment.itemId")
    public Comment saveComment(Comment comment){
        comment.setCreateAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

}
