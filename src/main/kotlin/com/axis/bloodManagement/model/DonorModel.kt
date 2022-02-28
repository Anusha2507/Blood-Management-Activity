package com.axis.bloodManagement.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class DonorModel(
    @Id
    @GeneratedValue
    val donorId:Int,
    val donorName:String,
    val dateOfDonation:String,
    val contactNumber: Number,
    val dateOfBirth:String,
    val sex:String,
    val address:String,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="blood_id", referencedColumnName = "bloodType")
    val bloodModel: BloodModel
) {


}