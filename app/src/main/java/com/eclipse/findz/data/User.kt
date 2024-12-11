package com.eclipse.findz.data

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "", // "UMKM" atau "Influencer"
    val phoneNumber: String = "",
    val businessField: String? = null, // Khusus UMKM
    val interestField: String? = null, // Khusus Influencer
    val instagramAccount: String? = null // Khusus Influencer
)

data class Influencer(
    val name: String = "",
    val profilePicUrl: Int? = null, // URL atau path ke gambar profil
    val rating: Float = 0f, // Rating influencer, bisa dari 1 sampai 5
)

data class InfluencerDetail(
    val name: String,
    val profilePic: Int? = null,
    val rating: Float,
    val category: String,
    val instagramFollowers: Int,
    val tiktokFollowers: Int
)
