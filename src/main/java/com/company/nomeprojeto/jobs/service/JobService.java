package com.company.nomeprojeto.jobs.service;

import com.company.nomeprojeto.jobs.dto.JobsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobService {
    private static final Map<Long, JobsDTO> jobs = new HashMap<>();

    public JobsDTO create(JobsDTO jobsDTO){
        Long nextId= jobs.keySet().size() + 1L;
        jobsDTO.setId(nextId);
        jobs.put(nextId, jobsDTO);
        return jobsDTO;
    }

    public JobsDTO update(JobsDTO jobsDTO, Long jobId){
        jobs.put(jobId, jobsDTO);
        return jobsDTO;
    }

    public JobsDTO getById(Long jobId){
        return jobs.get(jobId);
    }

    public List<JobsDTO> getAll(){
        return new ArrayList<>(jobs.values());
    }

    public String delete (Long jobId){
        jobs.remove(jobId);
        return "DELETE";
    }


}

