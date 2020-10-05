package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path="/posts", method = RequestMethod.GET)
    @ResponseBody
    public String postIndex() {
        return "posts index page";
    }

    @RequestMapping(path="/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable long id) {
        return "view an individual post";
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
