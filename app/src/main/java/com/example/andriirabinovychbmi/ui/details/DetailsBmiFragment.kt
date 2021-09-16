package com.example.andriirabinovychbmi.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.andriirabinovychbmi.R
import com.example.andriirabinovychbmi.databinding.FragmentDetailsBmiBinding

class DetailsBmiFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBmiBinding

    private lateinit var viewModel: DetailsBmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(DetailsBmiViewModel::class.java)
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

        viewModel.weight.observe(viewLifecycleOwner) {}

        binding.npHeight.apply {
            minValue = viewModel.minValue
            maxValue = viewModel.maxValue
            value = viewModel.weight.value ?: minValue
            wrapSelectorWheel = false
        }

        viewModel.height.observe(viewLifecycleOwner){}

        binding.npGender.apply {
            minValue = viewModel.minValue
            maxValue = viewModel.genderList.size
            displayedValues = viewModel.genderList
        }

        viewModel.gender.observe(viewLifecycleOwner) {
        }

        viewModel.calculateBtnEnabled.observe(viewLifecycleOwner, binding.btnCalculate::setEnabled)

        binding.btnCalculate.setOnClickListener { v: View ->
            viewModel::onCalculateClicked
            v.findNavController()
                .navigate(DetailsBmiFragmentDirections.actionFragmentDetailsBmiToFragmentResultsBmi())
        }

        binding.etName.addTextChangedListener { viewModel.onNameEdited(it.toString()) }
    }

    private fun setDetails() {
        viewModel.onWeightSelected(binding.npWeight.value)
    }
}