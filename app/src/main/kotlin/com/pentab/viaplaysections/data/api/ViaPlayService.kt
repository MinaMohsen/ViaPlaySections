package com.pentab.viaplaysections.data.api

import com.pentab.viaplaysections.data.entities.SectionDetails
import com.pentab.viaplaysections.data.entities.SectionsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * ViaPlay Sections API communication setup via Retrofit.
 */
interface ViaPlayService {

    @GET("androiddash-se")
    fun getSections(): Single<SectionsResponse>

    @GET
    fun getSectionDetails(@Url sectionURL: String): Single<SectionDetails>
}