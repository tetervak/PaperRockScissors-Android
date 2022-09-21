package ca.tetervak.paperrockscissors.model

data class GameData(
    val playerOneChoice: Choice,
    val playerTwoChoice: Choice,
    val result: GameResult
) {

    //val result: Result = getGameResult()
    constructor(playerOneChoice: Choice, playerTwoChoice: Choice) : this(
        playerOneChoice, playerTwoChoice, getGameResult(playerOneChoice, playerTwoChoice)
    )

    companion object {
        private fun getGameResult(playerOneChoice: Choice, playerTwoChoice: Choice): GameResult {
            return when (playerOneChoice) {
                Choice.PAPER -> when (playerTwoChoice) {
                    Choice.PAPER -> GameResult.REPLAY
                    Choice.ROCK -> GameResult.PLAYER_ONE_WINS
                    Choice.SCISSORS -> GameResult.PLAYER_TWO_WINS
                }

                Choice.ROCK -> when (playerTwoChoice) {
                    Choice.PAPER -> GameResult.PLAYER_TWO_WINS
                    Choice.ROCK -> GameResult.REPLAY
                    Choice.SCISSORS -> GameResult.PLAYER_ONE_WINS
                }

                Choice.SCISSORS -> when (playerTwoChoice) {
                    Choice.PAPER -> GameResult.PLAYER_ONE_WINS
                    Choice.ROCK -> GameResult.PLAYER_TWO_WINS
                    Choice.SCISSORS -> GameResult.REPLAY
                }
            }
        }
    }

}