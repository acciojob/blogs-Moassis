package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        Blog newBlog = new Blog();
        // newBlog.setId(userId);
        newBlog.setTitle(title);
        newBlog.setContent(content);
        // updating the blog details
        blogRepository1.save(newBlog);

        // Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId) {
        // find a blog
        Blog blog = blogRepository1.findBlogById(blogId);
        return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions) {
        // add an image to the blog after creating it
        Blog blog = findBlogById(blogId);
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId) {
        // delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
