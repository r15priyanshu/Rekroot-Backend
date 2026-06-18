package com.anshuit.rekroot.controllers;

import com.anshuit.rekroot.dtos.JobDto;
import com.anshuit.rekroot.entities.Job;
import com.anshuit.rekroot.services.DataTransferService;
import com.anshuit.rekroot.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    private final DataTransferService dataTransferService;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDto>> getAllJobs(@RequestParam(name = "fetchFull") boolean fetchFull) {
        List<Job> allJobs = jobService.getAllJobs();
        List<JobDto> allJobsDto = allJobs.stream().map(job -> dataTransferService.mapJobToJobDto(job, fetchFull)).toList();
        return new ResponseEntity<>(allJobsDto, HttpStatus.OK);
    }
}
