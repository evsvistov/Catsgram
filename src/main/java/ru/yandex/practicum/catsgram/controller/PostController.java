package ru.yandex.practicum.catsgram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping
    public Collection<Post> findAll() {
        return postService.findAll();
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