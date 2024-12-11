package com.eclipse.findz

import com.google.firebase.firestore.FirebaseFirestore

object FirestoreProvider {
    val firestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}