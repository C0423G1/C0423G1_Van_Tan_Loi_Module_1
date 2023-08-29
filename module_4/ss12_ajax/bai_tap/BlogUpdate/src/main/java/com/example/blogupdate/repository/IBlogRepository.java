package com.example.blogupdate.repository;

import com.example.blogupdate.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "SELECT * FROM blog WHERE category_id =  :categoryId", nativeQuery = true)
    Page<Blog> findCategory(@Param("categoryId") int categoryId,Pageable pageable);
    @Query(value = "SELECT * FROM blog order by date_date", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM Blog WHERE id = :id",nativeQuery = true)
    Blog findById(@Param("id") int id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Blog WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO blog (describes, title, category_id,date_date) VALUES (:describes, :title, :categoryId,CURDATE())", nativeQuery = true)
    void saveBlog(@Param("describes") String describes, @Param("title") String title, @Param("categoryId") int categoryId);
    @Query(value = "SELECT * FROM blog WHERE  title like :name", nativeQuery = true)
    Page<Blog> findCategoryName(@Param("name")String name, Pageable pageable);
    @Query(value = "SELECT * FROM blog WHERE  title like :name", nativeQuery = true)
    List<Blog> findCategoryName(@Param("name")String name);
    @Query(value = "SELECT * FROM blog WHERE category_id =  :id", nativeQuery = true)
    List<Blog> findCategoryById(int id);
    @Query(value = "SELECT * FROM Blog WHERE id <=:start AND id>=:count", nativeQuery = true)
    List<Blog> loadMoreBlogs(int start, int count);
}

