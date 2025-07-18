package com.example.jpa.repository;

import com.example.jpa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Query("select p from PostEntity p join fetch p.writer where p.title like %:keyword%")
    List<PostEntity> searchByTitle(@Param("keyword") String username);

    @Query("select p from PostEntity p join fetch p.writer where p.writer.username = :username")
    List<PostEntity> findByWriterUsername(@Param("username") String username);
}
