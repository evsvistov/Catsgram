package ru.yandex.practicum.catsgram.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    public Collection<Post> findAll(
            @RequestParam(name = "page", defaultValue = "1") int from,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sort) {
        return postService.findAll(from, size, sort);
    }

    @GetMapping("/posts/{id}")
    public Post findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.create(post, post.getAuthorId());
    }

    @PutMapping
    public Post update(@RequestBody Post newPost) {
        return postService.update(newPost);
    }
}