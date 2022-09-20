package ca.tetervak.paperrockscissors.model

data class GameData(val playerOneChoice: Choice, val playerTwoChoice: Choice){

    val result: Result = getGameResult()

    private fun getGameResult(): Result {
        return when (playerOneChoice){
            Choice.PAPER -> when(playerTwoChoice){
                Choice.PAPER -> Result.REPLAY
                Choice.ROCK -> Result.PLAYER_ONE_WINS
                Choice.SCISSORS -> Result.PLAYER_TWO_WINS
            }
            Choice.ROCK -> when(playerTwoChoice){
                Choice.PAPER -> Result.PLAYER_TWO_WINS
                Choice.ROCK -> Result.REPLAY
                Choice.SCISSORS -> Result.PLAYER_ONE_WINS
            }
            Choice.SCISSORS -> when(playerTwoChoice){
                Choice.PAPER -> Result.PLAYER_ONE_WINS
                Choice.ROCK -> Result.PLAYER_TWO_WINS
                Choice.SCISSORS -> Result.REPLAY
            }
        }
    }

    override fun toString() =
        "GameData(playerOneChoice=$playerOneChoice, playerTwoChoice=$playerTwoChoice, result=$result)"
}