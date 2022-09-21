package ca.tetervak.paperrockscissors.model

data class GameData(
    val playerOneChoice: Choice,
    val playerTwoChoice: Choice,
    val result: Result
) {

    //val result: Result = getGameResult()
    constructor(playerOneChoice: Choice, playerTwoChoice: Choice) : this(
        playerOneChoice, playerTwoChoice, getGameResult(playerOneChoice, playerTwoChoice)
    )

    companion object {
        private fun getGameResult(playerOneChoice: Choice, playerTwoChoice: Choice): Result {
            return when (playerOneChoice) {
                Choice.PAPER -> when (playerTwoChoice) {
                    Choice.PAPER -> Result.REPLAY
                    Choice.ROCK -> Result.PLAYER_ONE_WINS
                    Choice.SCISSORS -> Result.PLAYER_TWO_WINS
                }

                Choice.ROCK -> when (playerTwoChoice) {
                    Choice.PAPER -> Result.PLAYER_TWO_WINS
                    Choice.ROCK -> Result.REPLAY
                    Choice.SCISSORS -> Result.PLAYER_ONE_WINS
                }

                Choice.SCISSORS -> when (playerTwoChoice) {
                    Choice.PAPER -> Result.PLAYER_ONE_WINS
                    Choice.ROCK -> Result.PLAYER_TWO_WINS
                    Choice.SCISSORS -> Result.REPLAY
                }
            }
        }
    }

}