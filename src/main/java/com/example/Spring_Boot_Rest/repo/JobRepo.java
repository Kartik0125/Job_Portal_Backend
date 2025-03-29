package com.example.Spring_Boot_Rest.repo;

import com.example.Spring_Boot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}
