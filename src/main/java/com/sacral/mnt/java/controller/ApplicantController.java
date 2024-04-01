
package com.sacral.mnt.java.controller;

import com.sacral.mnt.java.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/validate-credit-evaluation")
    public String validateCreditEvaluation(@RequestParam double income, @RequestParam int creditScore) {
        return applicantService.validateCreditEvaluation(income, creditScore);
    }
}
