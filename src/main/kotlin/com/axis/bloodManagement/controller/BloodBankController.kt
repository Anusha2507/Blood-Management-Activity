package com.axis.bloodManagement.controller

import com.axis.bloodManagement.model.BloodBankModel
import com.axis.bloodManagement.service.BloodBankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("bloodBank")
class BloodBankController(
    @Autowired val bloodBankService: BloodBankService
) {
    @PostMapping("/")
    fun saveBloodBank(@RequestBody bloodBankModel: BloodBankModel): BloodBankModel {
        return bloodBankService.addBloodBank(bloodBankModel)
    }
    @GetMapping("/{id}")
    fun getBloodBankByGrp(@PathVariable id:String): Optional<BloodBankModel> {
        return bloodBankService.getBloodBankDataByGrp(id)
    }
    @DeleteMapping("/{id}")
    fun deleteBloodBankDataByGrp(@PathVariable id:String){
        return bloodBankService.deleteBloodBankDataByGrp(id)
    }
}