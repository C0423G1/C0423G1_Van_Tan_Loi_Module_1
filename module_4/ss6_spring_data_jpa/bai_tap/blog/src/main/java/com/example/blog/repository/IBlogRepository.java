package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "SELECT * FROM blog b INNER JOIN category c ON b.category_id = c.id WHERE c.id = :categoryId", nativeQuery = true)
    List<Blog> findCategory(@Param("categoryId") int categoryId);
}
