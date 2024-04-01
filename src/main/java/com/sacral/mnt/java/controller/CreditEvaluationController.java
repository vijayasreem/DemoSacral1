package com.sacral.mnt.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.mnt.java.service.CreditEvaluationService;

@RestController
public class CreditEvaluationController {

    private CreditEvaluationService creditEvaluationService;

    @Autowired
    public CreditEvaluationController(CreditEvaluationService creditEvaluationService) {
        this.creditEvaluationService = creditEvaluationService;
    }

    @GetMapping("/evaluate/{income}/{score}")
    public String evaluateCredit(@PathVariable double income, @PathVariable int score) {
        creditEvaluationService.validateCreditEvaluation(income, score);
        return "Credit evaluation completed.";
    }
}