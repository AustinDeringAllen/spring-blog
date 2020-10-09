package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(path="/posts", method = RequestMethod.GET)
    public String postIndex(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        for(int i=0; i<2; i++) {
            Post post = new Post("Post " + i, "This is post " + i);
            posts.add(post);
        }

        model.addAttribute("posts",posts);
        return "/posts/index";
    }

    @RequestMapping(path="/posts/{id}", method = RequestMethod.GET)
    public String individualPost(@PathVariable long id, Model model) {
        Post post = new Post("I miss you", "I miss the good old days");
        model.addAttribute("post",post);
        return "/posts/show";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String postForm() {
        return "view the form for creating a post";
    }

    @RequestMapping(path="/posts", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
