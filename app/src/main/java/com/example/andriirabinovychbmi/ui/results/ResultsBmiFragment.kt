package com.example.andriirabinovychbmi.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.andriirabinovychbmi.R
import com.example.andriirabinovychbmi.databinding.FragmentResultsBinding

class ResultsBmiFragment : Fragment(){

    private lateinit var binding: FragmentResultsBinding

    private lateinit var viewModel: ResultsBmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ResultsBmiViewModel::class.java)
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResultsBinding.bind(view)

        binding.tvNameAndResult.text

    }
}