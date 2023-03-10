package com.driver.repositories;

import com.driver.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    // @Query("select i from Image i where i.Id =:Id")
    // Image findById(int Id);

}
