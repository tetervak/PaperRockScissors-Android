package ca.tetervak.paperrockscissors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.paperrockscissors.model.Choice
import ca.tetervak.paperrockscissors.model.GameData
import ca.tetervak.paperrockscissors.model.PaperRockScissors

class MainViewModel : ViewModel() {

    private val _gameData = MutableLiveData<GameData>()
    val gameData: LiveData<GameData> = _gameData

    fun setUserChoice(userChoice: Choice) {
        _gameData.value = PaperRockScissors.play(playerTwoChoice = userChoice)
    }
}