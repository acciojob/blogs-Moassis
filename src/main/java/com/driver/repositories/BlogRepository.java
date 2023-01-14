package com.driver.repositories;

import com.driver.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("select b from Blog b where b.Id =:blogId")
    Blog findBlogById(int blogId);

}
