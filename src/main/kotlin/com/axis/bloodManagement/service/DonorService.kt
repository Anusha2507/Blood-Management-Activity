package com.axis.bloodManagement.service

import com.axis.bloodManagement.model.DonorModel
import com.axis.bloodManagement.repository.BloodRepository
import com.axis.bloodManagement.repository.DonorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DonorService(
    @Autowired val donorRepository: DonorRepository,
    @Autowired val bloodRepository: BloodRepository
) {
    fun saveDonor(donorModel: DonorModel): DonorModel {
        return donorRepository.save(donorModel)
    }

    fun getDonor(id: Int): Optional<DonorModel> {
        return donorRepository.findById(id)
    }

    fun deleteDonor(id: Int) {
        return donorRepository.deleteById(id)
    }

    fun saveDonorToBlood(donorId: Int, bloodId: String): DonorModel {
        val donor = donorRepository.findById(donorId).get()
        val blood = bloodRepository.findById(bloodId).get()
        blood.addDonor(donor)

        return donorRepository.save(donor)
    }




}

