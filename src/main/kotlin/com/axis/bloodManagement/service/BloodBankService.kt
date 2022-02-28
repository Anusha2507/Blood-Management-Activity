package com.axis.bloodManagement.service

import com.axis.bloodManagement.model.BloodBankModel
import com.axis.bloodManagement.repository.BloodBankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BloodBankService (
    @Autowired val bloodBankRepository: BloodBankRepository
        ){
    fun addBloodBank(bloodBankModel: BloodBankModel): BloodBankModel {
        return bloodBankRepository.save(bloodBankModel)
    }

    fun getBloodBankDataByGrp(id: String): Optional<BloodBankModel> {
        return bloodBankRepository.findById(id)
    }

    fun deleteBloodBankDataByGrp(id: String) {
        return bloodBankRepository.deleteById(id)
    }
}