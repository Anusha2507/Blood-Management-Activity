package com.axis.bloodManagement.controller

import com.axis.bloodManagement.model.DonorModel
import com.axis.bloodManagement.service.DonorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DonorController(
    @Autowired val donorService: DonorService
) {

    @PostMapping("/donor")
    fun saveDonor(@RequestBody donorModel: DonorModel): DonorModel {
        return donorService.saveDonor(donorModel)
    }

    @GetMapping("/donor/{id}")
    fun getDonor(@PathVariable id: Int): Optional<DonorModel> {
        return donorService.getDonor(id)
    }

    @DeleteMapping("/donor/{id}")
    fun deleteDonor(@PathVariable id: Int) {
        return donorService.deleteDonor(id)
    }

    @PutMapping("/donor/{donorId}/{bloodId}")
    fun addDonorToBlood(
        @PathVariable donorId:Int,
        @PathVariable bloodId:String
    ): DonorModel {
        return donorService.saveDonorToBlood(donorId,bloodId)
    }

}