package com.zhku.mh.batch_demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;
    @GetMapping("/get")
    public void hello(){
        try {
            jobLauncher.run(job,new JobParameters());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
