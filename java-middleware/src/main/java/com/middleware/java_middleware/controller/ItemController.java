package com.middleware.java_middleware.controller;

import com.middleware.java_middleware.model.Comment;
import com.middleware.java_middleware.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")

public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<String>> search(@RequestParam String q){
        return ResponseEntity.ok(itemService.searchItems(q));
    }

    @GetMapping("/show/{itemId}")
    public ResponseEntity<List<Comment>> show(@PathVariable String itemId){
        return ResponseEntity.ok(itemService.getItemComments(itemId));
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment savedComment = itemService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    
}
