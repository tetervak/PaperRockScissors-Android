package ca.tetervak.paperrockscissors.model

import kotlin.random.Random

class PaperRockScissors {
    companion object {
        fun play(playerOneChoice: Choice, playerTwoChoice: Choice): GameData {
            return GameData(playerOneChoice, playerTwoChoice)
        }

        fun play(playerTwoChoice: Choice, random: Random = Random.Default) =
            play(playerOneChoice = getRandomChoice(random), playerTwoChoice)

        fun getRandomChoice(random: Random = Random.Default) = Choice.values().random(random)
    }
}