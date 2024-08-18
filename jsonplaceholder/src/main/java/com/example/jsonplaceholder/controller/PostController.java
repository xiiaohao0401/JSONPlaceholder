package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.comparator.IgnoreCaseComparator;
import com.example.jsonplaceholder.comparator.StandardComparator;
import com.example.jsonplaceholder.comparator.TitleLengthComparator;
import com.example.jsonplaceholder.model.Post;
import com.example.jsonplaceholder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPosts() {
        return postService.getFormattedPosts(); //retrieve list of post
    }

    @GetMapping("/longest-title")
    public Post getPostWithLongestTitle(@RequestParam(defaultValue = "standard") String comparatorType) {
        TitleLengthComparator comparator;

        
        if (comparatorType.equalsIgnoreCase("ignoreCase")) {
            comparator = new IgnoreCaseComparator();
        } else {
            comparator = new StandardComparator(); 
        }

        Post longestTitlePost = postService.findPostWithLongestTitle(comparator); //retrieve based on requestParam post
        System.out.println("Longest Title: " + longestTitlePost.getTitle());
        System.out.println("Body: " + longestTitlePost.getBody());
        System.out.println("Title Length: " + longestTitlePost.getTitleLength());
        return longestTitlePost;
    }
}
