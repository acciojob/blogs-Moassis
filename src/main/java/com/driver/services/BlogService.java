package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs() {
        // find all blogs
        List<Blog> blogs = blogRepository1.findAll();
        return blogs;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        // create a blog at the current time
        Blog blog = new Blog();
        // newBlog.setId(userId);
        blog.setTitle(title);
        blog.setContent(content);
        User user = userRepository1.findById(userId).get();
        blog.setUser(user);
        // updating the blog details
        List<Blog> blogs = user.getBlogList();
        blogs.add(blog);
        user.setBlogList(blogs);
        // Updating the userInformation and changing its blogs
        blogRepository1.save(blog);
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId) {
        // find a blog
        Blog blog = blogRepository1.findById(blogId).get();
        return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions) {
        // add an image to the blog after creating it
        Blog blog = blogRepository1.findById(blogId).get();
        imageService1.createAndReturn(blog, description, dimensions);

    }

    public void deleteBlog(int blogId) {
        // delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
