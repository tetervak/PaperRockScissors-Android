package ca.tetervak.paperrockscissors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ca.tetervak.paperrockscissors.databinding.FragmentPlayBinding
import ca.tetervak.paperrockscissors.model.Choice
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)

        binding.playButton.setOnClickListener {
            val userChoice = getUserChoice()
            if(userChoice != null){
                mainViewModel.setUserChoice(userChoice)
                findNavController().navigate(R.id.action_playFragment_to_resultFragment)
            } else {
                remindToSelect()
            }
        }
        return binding.root
    }

    private fun getUserChoice(): Choice? {
        return when(binding.userChoiceGroup.checkedRadioButtonId){
            R.id.paper_button -> Choice.PAPER
            R.id.rock_button -> Choice.ROCK
            R.id.scissors_button -> Choice.SCISSORS
            else -> null
        }
    }

    private fun remindToSelect() {
        Snackbar.make(binding.root, getString(R.string.make_your_choice), Snackbar.LENGTH_SHORT).show()
    }

    private fun selectRandomChoice(){
        with(binding) {
            when ((1..3).random()) {
                1 -> paperButton.isChecked = true
                2 -> rockButton.isChecked = true
                3 -> scissorsButton.isChecked = true
            }
        }
    }

    override fun onStart() {
        super.onStart()
        selectRandomChoice()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}