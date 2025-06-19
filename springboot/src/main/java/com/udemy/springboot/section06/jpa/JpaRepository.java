package com.udemy.springboot.section06.jpa;

import com.udemy.springboot.section06.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course c) {
        entityManager.merge(c);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course c = entityManager.find(Course.class, id);
        entityManager.remove(c);
    }
}
