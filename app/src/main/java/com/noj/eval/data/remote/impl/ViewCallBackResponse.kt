package com.noj.eval.data.remote.impl

import com.noj.eval.BaseView
import com.noj.eval.BuildConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewCallBackResponse<T>(
        private val view: BaseView,
        private val responseCallback: (T?) -> Unit
) : Callback<T> {

    fun onStart() {
        view.showLoading()
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        view.dismissLoading()
        view.showGeneralError()
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        view.dismissLoading()
        if (response != null && response.isSuccessful) {
            responseCallback(response.body())
        } else {
            view.showGeneralError()
        }
    }

    /**
     * This methods is only used to mock the server, should not be use in prod apk!!
     */
    fun mockResponse(response: T) {
        if (BuildConfig.DEBUG) {
            responseCallback(response)
        } else {
            error("Never call this method in prod apk!!")
        }
    }

}
