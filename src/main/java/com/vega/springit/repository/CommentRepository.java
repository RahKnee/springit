package com.vega.springit.repository;

import com.vega.springit.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {
}
