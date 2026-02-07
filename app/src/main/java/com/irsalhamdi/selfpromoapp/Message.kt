package com.irsalhamdi.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val startDate: String?,
    val jobTitleSpinner: String?,
    val immediateStartCheckBox: Boolean,
    val juniorCheckBox: Boolean,
): Serializable {
    fun getFullJobDescription(): String {
        return if (juniorCheckBox){
            "A Junior $jobTitleSpinner"
        }else{
            "An $jobTitleSpinner"
        }
    }

    fun getAvailability(): String {
        return if (immediateStartCheckBox) {
            "immediately"
        } else {
            "from $startDate"
        }
    }
}