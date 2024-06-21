package com.geeks.iesson_1_5

class Presenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun AttachView(view: CounterView) {
        this.view = view

    }

    fun onDecrementButtonClicked() {
        model.dec()
        view?.updateCount(model.getResult())
    }
    fun onIncrementButtonClicked(){
        model.inc()
        view?.updateCount(model.getResult())
        if (model.getResult() == 10){
            view?.showToast("Поздравляем")
        } else if (model.getResult() == 15){
            view?.changeColor()
        }
    }

    fun detachView() {
        this.view = null
    }


}