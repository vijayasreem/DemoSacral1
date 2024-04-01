
package com.sacral.mnt.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sacral.mnt.java.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    @Query("SELECT a FROM Applicant a WHERE a.annualIncome >= :income AND a.creditScore >= :score")
    Applicant findByIncomeAndCreditScore(double income, int score);

}
