package ca.tetervak.paperrockscissors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ca.tetervak.paperrockscissors.databinding.FragmentResultBinding
import ca.tetervak.paperrockscissors.model.Choice
import ca.tetervak.paperrockscissors.model.GameData
import ca.tetervak.paperrockscissors.model.GameResult


class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        mainViewModel.liveGameData.observe(viewLifecycleOwner) { gameData ->
            updateOutputs(gameData)
        }

        binding.repeatButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun updateOutputs(data: GameData) {
        binding.computerChoice.text = choiceToString(data.playerOneChoice)
        binding.userChoice.text = choiceToString(data.playerTwoChoice)
        binding.resultMessage.text = resultToString(data.result)
    }

    private fun choiceToString(choice: Choice): String {
        return when (choice) {
            Choice.PAPER -> getString(R.string.paper)
            Choice.ROCK -> getString(R.string.rock)
            Choice.SCISSORS -> getString(R.string.scissors)
        }
    }

    private fun resultToString(result: GameResult): String {
        return when (result) {
            GameResult.PLAYER_ONE_WINS -> getString(R.string.computer_wins)
            GameResult.PLAYER_TWO_WINS -> getString(R.string.you_win)
            GameResult.REPLAY -> getString(R.string.replay)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}