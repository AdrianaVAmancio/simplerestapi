package com.company.nomeprojeto.jobs.controller;

import com.company.nomeprojeto.jobs.dto.JobsDTO;
import com.company.nomeprojeto.jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobsController {
    @Autowired
    private JobService jobService;

    @PostMapping
    @ResponseBody
    public JobsDTO create(@RequestBody JobsDTO tarefaDTO){
        return jobService.create(tarefaDTO);
    }

    @PutMapping("/{jobId}")
    @ResponseBody
    public JobsDTO update(@PathVariable("jobId") Long tarefaId,
                          @RequestBody JobsDTO jobsDTO){
        return jobService.update(jobsDTO, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<JobsDTO> getAll(){
        return jobService.getAll();
    }

    @DeleteMapping("/{jobId}")
    @ResponseBody
    public String delete(@PathVariable("jobId") Long jobId){
        return jobService.delete(jobId);
    }
}
