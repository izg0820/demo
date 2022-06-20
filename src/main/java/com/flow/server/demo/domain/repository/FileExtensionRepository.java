package com.flow.server.demo.domain.repository;

import com.flow.server.demo.domain.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FileExtensionRepository extends JpaRepository<FileExtension, String> {

    @Query("select f from FileExtension f where f.fixed = true")
    List<FileExtension> findByFixed();

    @Query("select f from FileExtension f where f.fixed = false")
    List<FileExtension> findByCustom();
}
