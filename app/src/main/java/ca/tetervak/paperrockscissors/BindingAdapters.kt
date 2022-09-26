package ca.tetervak.paperrockscissors

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.paperrockscissors.model.Choice
import ca.tetervak.paperrockscissors.model.GameResult

@BindingAdapter("gameChoice")
fun setGameChoice(textView: TextView, choice: Choice?) {
    with(textView.resources) {
        if (choice is Choice) {
            textView.text = when (choice) {
                Choice.PAPER -> getString(R.string.paper)
                Choice.ROCK -> getString(R.string.rock)
                Choice.SCISSORS -> getString(R.string.scissors)
            }
        }
    }
}

@BindingAdapter("gameResult")
fun setGameResult(textView: TextView, gameResult: GameResult?){
    with(textView.resources){
        if(gameResult is GameResult){
            textView.text = when (gameResult) {
                GameResult.PLAYER_ONE_WINS -> getString(R.string.computer_wins)
                GameResult.PLAYER_TWO_WINS -> getString(R.string.you_win)
                GameResult.REPLAY -> getString(R.string.replay)
            }
        }
    }
}