package rein.tianh.contractClass

import android.provider.BaseColumns

object ReinDBContracts{
    object DetailsEntry : BaseColumns {
        const val TABLE_NAME = "aboutMe"
        const val COLUMN_NAME = "studentName"
        const val COLUMN_MAJOR = "studentMajor"
    }
}
