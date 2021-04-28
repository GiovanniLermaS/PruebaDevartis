package com.example.pruebadevartis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebadevartis.db.model.LoginRegister
import com.example.pruebadevartis.db.model.ResponseLoginRegister
import com.example.pruebadevartis.repository.MainActivityRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val mainActivityRepository: MainActivityRepository) :
    ViewModel() {

    private var successMainResponseLoginRegister: MutableLiveData<ResponseLoginRegister>? =
        MutableLiveData()
    private var errorMainRegister: MutableLiveData<String>? = MutableLiveData<String>()

    fun getSuccessMain(): LiveData<ResponseLoginRegister>? {
        return successMainResponseLoginRegister
    }

    fun setSuccessMain(team: ResponseLoginRegister?) {
        this.successMainResponseLoginRegister?.value = team
    }

    fun getErrorMain(): LiveData<String>? {
        return errorMainRegister
    }

    fun setErrorMain(message: String?) {
        this.errorMainRegister?.value = message
    }

    fun loginRegisterUser(loginRegister: LoginRegister, isLogin: Boolean) {
        mainActivityRepository.loginRegisterUser(loginRegister, isLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<ResponseLoginRegister>> {
                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {
                    errorMainRegister?.value = e.message
                }

                override fun onSuccess(responseLoginRegister: Response<ResponseLoginRegister>) {
                    try {
                        if (responseLoginRegister.body() != null) {
                            successMainResponseLoginRegister?.value = responseLoginRegister.body()
                            setSuccessMain(null)
                        } else {
                            val responseRegisterErrorBody = ResponseLoginRegister()
                            responseRegisterErrorBody.message = JSONObject(
                                responseLoginRegister.errorBody()?.string()
                            ).get("message") as String
                            successMainResponseLoginRegister?.value = responseRegisterErrorBody
                            setSuccessMain(null)
                        }
                    } catch (e: Exception) {
                        errorMainRegister?.value =
                            "El servicio falló, vuelve a intentar"
                    }
                }
            })
    }
}
