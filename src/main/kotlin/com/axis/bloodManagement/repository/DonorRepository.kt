package com.axis.bloodManagement.repository

import com.axis.bloodManagement.model.DonorModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonorRepository:JpaRepository<DonorModel,Int> {
}