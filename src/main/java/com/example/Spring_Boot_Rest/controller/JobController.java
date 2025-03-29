package com.example.Spring_Boot_Rest.controller;

import com.example.Spring_Boot_Rest.model.JobPost;
import com.example.Spring_Boot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://job-portal-ten-nu.vercel.app/")
public class JobController {

    @Autowired
    private JobService service;

//    To get all job posts
    @GetMapping("getAllJobs")
//    @ResponseBody
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

//    To get a particular job post
    @GetMapping("getJob/{id}")
    public JobPost getJobPost(@PathVariable("id") int postId)
    {
        return service.getJob(postId);
    }

//    To add a job post
    @PostMapping("addJob")
    public JobPost addJob(@RequestBody JobPost job)
    {
        service.addJob(job);
        return service.getJob(job.getPostId());
    }

//    To search by keyword
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchKeyword(@PathVariable("keyword") String keyword)
    {
        return service.searchKeyword(keyword);
    }

//    To update a job post
    @PutMapping("updateJob")
    public JobPost updateJob(@RequestBody JobPost job)
    {
        System.out.println("Update called");
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

//    To delete a job
    @DeleteMapping("deleteJob/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

//    by default jobs
    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }
}
