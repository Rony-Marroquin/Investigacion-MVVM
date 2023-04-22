package edu.udb.sv.investigacionmvvm.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.udb.sv.investigacionmvvm.model.Message

// clase para recuperar los datos del model y preparar para utilizarlas en main Activity
class MessageViewModel: ViewModel() {
    val messageLiveData = MutableLiveData<Message>()

    fun getMessage(){
        val message = Message("Hola mundo")
        messageLiveData.postValue(message)
    }
}