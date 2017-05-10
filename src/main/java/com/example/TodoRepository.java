package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Piotrek on 2017-05-10.
 */
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
