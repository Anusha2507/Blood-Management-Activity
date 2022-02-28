package com.axis.bloodManagement.service

import com.axis.bloodManagement.model.BloodModel
import com.axis.bloodManagement.repository.BloodBankRepository
import com.axis.bloodManagement.repository.BloodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BloodService(
    @Autowired val bloodRepository: BloodRepository,
    @Autowired val bloodBankRepository: BloodBankRepository
) {
    fun save(bloodModel: BloodModel): BloodModel {
        return bloodRepository.save(bloodModel)
    }

    fun find(id: String): Optional<BloodModel> {
        return bloodRepository.findById(id)
    }

    fun delete(id: String) {
        return bloodRepository.deleteById(id)
    }

    fun saveBloodToBank(bloodId: String): BloodModel {
        val bank = bloodBankRepository.findById(bloodId).get()
        val blood = bloodRepository.findById(bloodId).get()
        bank.addBlood(blood)
        return bloodRepository.save(blood)
    }
}