package com.axis.bloodManagement.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class BloodModel(
    @Id
    val bloodType:String,
    @GeneratedValue
    val bloodBagNumber : Int,
    @GeneratedValue
    val bloodCode:String,

    @OneToMany(mappedBy = "bloodModel")
    val listOfDonors: MutableSet<DonorModel>,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_bank", referencedColumnName = "bloodType")
    val bloodBankModel: BloodBankModel

        ){
    fun addDonor(donor: DonorModel): Boolean? {
        return listOfDonors.add(donor)
    }


}