package com.example.pruebadevartis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebadevartis.db.model.Register
import com.example.pruebadevartis.repository.MainActivityRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val mainActivityRepository: MainActivityRepository) :
    ViewModel() {

    private var successMainRegister: MutableLiveData<Register>? = MutableLiveData()
    private var errorMainRegister: MutableLiveData<String>? = MutableLiveData<String>()

    fun getSuccessMain(): LiveData<Register>? {
        return successMainRegister
    }

    fun setSuccessMain(team: Register?) {
        this.successMainRegister?.value = team
    }

    fun getErrorMain(): LiveData<String>? {
        return errorMainRegister
    }

    fun setErrorMain(message: String?) {
        this.errorMainRegister?.value = message
    }

    fun registerUser(league: String) {
        mainActivityRepository.registerUser(league).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<Register>> {
                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {
                    errorMainRegister?.value = e.message
                }

                override fun onSuccess(teams: Response<Register>) {
                    try {
                        successMainRegister?.value = teams.body()
                    } catch (e: Exception) {
                        errorMainRegister?.value =
                            "El servicio falló, vuelve a intentar"
                    }
                }
            })
    }
}
