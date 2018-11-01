package com.pentab.viaplaysections.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Data classes to hold responses from API calls and for db.
 */

data class SectionsResponse(
    @SerializedName("_links") val links: Links,
    val responseCode: ResponseCode
)

data class Links(
    @SerializedName("viaplay:sections")
    val sections: List<ViaplaySection>
)


data class ViaplaySection(
    val href: String,
    val id: String,
    val title: String
)

data class ResponseCode(
    val code: Int,
    val httpStatus: Int,
    val statusCode: Int
)

data class SectionDetails(
    val description: String,
    val pageType: String,
    val responseCode: ResponseCode,
    val sectionId: String,
    val title: String,
    val type: String
)

@Parcelize
@Entity(tableName = "section")
data class Section(
    @PrimaryKey val id: String,
    val href: String,
    val title: String,
    var sectionTitle: String? = null,
    var sectionDesc: String? = null
) : Parcelable

