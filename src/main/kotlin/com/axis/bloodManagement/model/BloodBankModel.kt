package com.axis.bloodManagement.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class BloodBankModel (
    @Id
    val bloodType:String,
    val bloodBagNumber :Int,
    val quantityOnHandMl :Int,
    val address:String,
    @OneToMany(mappedBy = "bloodBankModel")
    val listOfBloodGrps: MutableSet<BloodModel>

        ){
    fun addBlood(blood: BloodModel): Boolean {
        return listOfBloodGrps.add(blood)
    }
}