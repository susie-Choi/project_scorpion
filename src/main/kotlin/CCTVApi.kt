package com.skiresort.cctv

import retrofit2.Call
import retrofit2.http.GET

interface CCTVApi {
    @GET("cctv_list")  // 실제 API 엔드포인트로 변경 필요
    fun getCCTVList(): Call<List<CCTV>>
}
