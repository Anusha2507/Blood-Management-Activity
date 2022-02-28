package com.axis.bloodManagement.controller

import com.axis.bloodManagement.model.BloodModel
import com.axis.bloodManagement.model.DonorModel
import com.axis.bloodManagement.service.BloodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/blood")
class BloodController(
    @Autowired val bloodService: BloodService
) {
    @PostMapping("/")
    fun addBlood(@RequestBody bloodModel: BloodModel): BloodModel {
        return bloodService.save(bloodModel)
    }
    @GetMapping("/{id}")
    fun findBlood(@PathVariable id:String): Optional<BloodModel> {
        return bloodService.find(id)
    }
    @DeleteMapping("/{id}")
    fun deleteBlood(@PathVariable id:String){
        return bloodService.delete(id)
    }
    @PutMapping("bloodBank/{bloodId}/blood")
    fun addBloodToBank(
        @PathVariable bloodId:String
    ): BloodModel {
        return bloodService.saveBloodToBank(bloodId)
    }

}