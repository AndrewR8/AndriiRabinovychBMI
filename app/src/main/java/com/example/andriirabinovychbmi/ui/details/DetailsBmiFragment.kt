package com.example.andriirabinovychbmi.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.andriirabinovychbmi.R
import com.example.andriirabinovychbmi.databinding.FragmentDetailsBmiBinding

class DetailsBmiFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBmiBinding

    private val viewModel: DetailsBmiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_bmi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailsBmiBinding.bind(view)

        binding.npWeight.apply {
            minValue = viewModel.minValue
            maxValue = viewModel.maxValue
            value = viewModel.weight.value ?: minValue
            wrapSelectorWheel = false
        }
            .also { it.setOnValueChangedListener { _, _, newVal -> viewModel.onWeightSelected(newVal) } }

        binding.npHeight.apply {
            minValue = viewModel.minValue
            maxValue = viewModel.maxValue
            value = viewModel.height.value ?: minValue
            wrapSelectorWheel = false
        }
            .also { it.setOnValueChangedListener { _, _, newVal -> viewModel.onHeightSelected(newVal) } }

        binding.npGender.apply {
            minValue = viewModel.minValue
            maxValue = viewModel.genderList.size
            displayedValues = viewModel.genderList
        }

        viewModel.calculateBtnEnabled.observe(viewLifecycleOwner, binding.btnCalculate::setEnabled)

        binding.btnCalculate.setOnClickListener { v: View ->
            viewModel.onCalculateClicked()
            v.findNavController()
                .navigate(DetailsBmiFragmentDirections.actionFragmentDetailsBmiToDialogResultsFragment())
        }

        binding.etName.addTextChangedListener { viewModel.onNameEdited(it.toString()) }
    }
}