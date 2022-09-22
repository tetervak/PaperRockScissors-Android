package ca.tetervak.paperrockscissors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.paperrockscissors.model.Choice
import ca.tetervak.paperrockscissors.model.GameData
import ca.tetervak.paperrockscissors.model.PaperRockScissors

class MainViewModel : ViewModel() {

    private val _liveGameData = MutableLiveData<GameData>()
    val liveGameData: LiveData<GameData> = _liveGameData

    fun setUserChoice(userChoice: Choice) {
        _liveGameData.value = PaperRockScissors.play(playerTwoChoice = userChoice)
    }
}