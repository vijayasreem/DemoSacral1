package com.sacral.mnt.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.mnt.java.entity.Applicant;
import com.sacral.mnt.java.repository.ApplicantRepository;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public String validateCreditEvaluation(double income, int creditScore) {
        Applicant applicant = applicantRepository.findByIncomeAndCreditScore(income, creditScore);
        
        if (income >= 30000 && creditScore >= 700) {
            return "Congratulations! You are eligible for a credit score with a high limit.";
        } else if (income >= 20000 && creditScore >= 600) {
            return "You are eligible for a credit score with a moderate limit.";
        } else {
            return "Sorry, you are not eligible for a credit score.";
        }
    }
}