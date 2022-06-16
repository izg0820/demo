package com.flow.server.demo.domain.repository;

import com.flow.server.demo.domain.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileExtensionRepository extends JpaRepository<FileExtension, String> {

}
