package com.axis.bloodManagement.repository

import com.axis.bloodManagement.model.BloodBankModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodBankRepository:JpaRepository<BloodBankModel,String> {
}