package com.axis.bloodManagement.repository

import com.axis.bloodManagement.model.BloodModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodRepository:JpaRepository<BloodModel,String> {
}