package com.example.jsonplaceholder.service;

import com.example.jsonplaceholder.comparator.TitleLengthComparator;
import com.example.jsonplaceholder.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private static final String URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    public List<Post> getPosts() {
        Post[] postsArray = restTemplate.getForObject(URL, Post[].class);
        return Arrays.asList(postsArray);
    }

    public Post findPostWithLongestTitle(TitleLengthComparator comparator) {
        List<Post> posts = getPosts();
        if (posts == null || posts.isEmpty()) {
            return null;
        }
        Post longestTitlePost = posts.get(0);
        for (Post post : posts) {
            if (comparator.isLonger(post.getTitle(), longestTitlePost.getTitle())) {
                longestTitlePost = post;
            }
        }
        longestTitlePost.setTitleLength(longestTitlePost.getTitle().length()); 
        return longestTitlePost;
    }

    public List<Post> getFormattedPosts() {
        
        List<Post> posts = getPosts();
       
        if (posts == null || posts.isEmpty()) {
            return posts; 
        }
      
        for (Post post : posts) {
            post.setTitleLength(post.getTitle().length());
        }

        return posts;
    }
}
