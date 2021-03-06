package com.codeup.blog;

import com.codeup.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final EmailService emailService;

    public PostController(PostRepository postRepo, UserRepository userRepo, EmailService emailService) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable long id, Model model) {
        Post post = postRepo.getAdById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userRepo.getOne(3L));
        postRepo.save(post);
        emailService.prepareAndSend(post,"Email Created","Congratulations! Your post has been created!");
        return "redirect:/posts/";
    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    public String createPost(@RequestParam(name = "title") String title,
//                             @RequestParam(name = "body") String body,
//                             Model model) {
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(body);
//        post.setUser(userRepo.getOne(2L));
//        postRepo.save(post);
//        return "redirect:/posts/" + post.getId();
//    }


    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, Model model) {
        Post post = postRepo.getAdById(id);
        if (post != null) {
            postRepo.delete(post);
        }
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        Post post = postRepo.getAdById(id);
        if (post == null) {
            return "redirect:/posts/index";
        }
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String updatePost(@RequestParam(name = "id") long id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "body") String body,
                             Model model) {
        Post post = postRepo.getAdById(id);
        if (post == null) {
            return "redirect:/posts/index";
        }
        post.setTitle(title);
        post.setBody(body);
        postRepo.save(post);
        return "redirect:/posts/" + post.getId();
    }
}
