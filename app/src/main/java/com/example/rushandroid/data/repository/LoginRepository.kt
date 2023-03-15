package com.example.rushandroid.data.repository

import com.example.rushandroid.ResponsesStr
import com.example.rushandroid.data.entities.RequestUser
import com.example.rushandroid.data.entities.Users
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import io.reactivex.Single
import javax.inject.Inject

class LoginRepository @Inject constructor(private val db: FirebaseFirestore) {

    fun processLogin(mobNum: String, mpin: String): Single<RequestUser> {
        return Single.create { emitter ->
            val response = RequestUser(404, ResponsesStr.FailedLogin.str, null)
            db.collection("users")
                .whereEqualTo("mobile", mobNum)
                .whereEqualTo("mpin", mpin)
                .get()
                .addOnSuccessListener {
                    if (it.documents.isNotEmpty()) {
                        val user = it.documents[0].toObject<Users>()
                        response.message = ResponsesStr.SuccessLogin.str
                        response.data = user
                    }else{
                        response.status = 200
                    }
                    emitter.onSuccess(response)
                }
                .addOnFailureListener {
                    emitter.onSuccess(response)
                }
        }
    }
    fun processRegistration(req: RequestUser):
            Single<RequestUser> {
        return Single.create { emitter ->
            val col = db.collection("users").document()
            val map: Map<String, Any?> = mapOf(
                "first_name" to req.data?.first_name,
                "last_name" to req.data?.last_name,
                "mpin" to req.data?.mpin,
                "mobile" to req.data?.mobile
            )
            var success: Boolean = false
            db.runTransaction {
                processLogin(req.data?.mobile ?: "",req.data?.mpin ?: "").subscribe { res, throwable ->
                    if (res.data == null) {
                        success= true
                        col.update(map)
                    } else {
                        success = false
                    }
                }
            }.addOnCompleteListener {
                    if (success) {
                        req.message = ResponsesStr.SuccessRegistration.str
                        req.status = 200
                    }else{
                        req.message = ResponsesStr.FailedRegistration.str
                        req.status = 404
                        req.data = null
                    }
                    emitter.onSuccess(req)
             }

        }
    }
}