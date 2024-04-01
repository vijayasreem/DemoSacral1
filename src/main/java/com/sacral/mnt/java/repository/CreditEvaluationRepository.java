
package com.sacral.mnt.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditEvaluationRepository extends JpaRepository<CreditEvaluation, Long> {

    @Query("SELECT ce FROM CreditEvaluation ce WHERE ce.annualIncome >= :income AND ce.creditScore >= :score")
    CreditEvaluation findByIncomeAndScore(double income, int score);
    
    @Query("SELECT ce FROM CreditEvaluation ce WHERE ce.annualIncome >= 30000 AND ce.creditScore >= 700")
    CreditEvaluation findHighLimitEligibleApplicant();
    
    @Query("SELECT ce FROM CreditEvaluation ce WHERE ce.annualIncome >= 20000 AND ce.creditScore >= 600")
    CreditEvaluation findModerateLimitEligibleApplicant();
}
