package com.first.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.first.dao.BookCategory;
public interface  BookCategoryRepository extends JpaRepository<BookCategory, Integer>{


}
