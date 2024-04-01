package com.sacral.mnt.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.mnt.java.repository.CreditEvaluation;
import com.sacral.mnt.java.repository.CreditEvaluationRepository;

@Service
public class CreditEvaluationService {

    private CreditEvaluationRepository creditEvaluationRepository;

    @Autowired
    public CreditEvaluationService(CreditEvaluationRepository creditEvaluationRepository) {
        this.creditEvaluationRepository = creditEvaluationRepository;
    }

    public void validateCreditEvaluation(double income, int score) {
        CreditEvaluation creditEvaluation = creditEvaluationRepository.findByIncomeAndScore(income, score);

        if (creditEvaluation != null) {
            System.out.println("Congratulations! You are eligible for a credit score with a high limit.");
        } else {
            creditEvaluation = creditEvaluationRepository.findModerateLimitEligibleApplicant();

            if (creditEvaluation != null) {
                System.out.println("You are eligible for a credit score with a moderate limit.");
            } else {
                System.out.println("Sorry, you are not eligible for a credit score.");
            }
        }
    }
}
