package id.furqoncreatice.resepmama2.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id:Int,
    val name:String,
    val image:String
) : Parcelable
