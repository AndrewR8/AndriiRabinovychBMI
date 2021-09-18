package com.example.andriirabinovychbmi.ui.results

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.andriirabinovychbmi.R
import com.example.andriirabinovychbmi.databinding.DialogFragmentResultsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ResultsBmiFragment : BottomSheetDialogFragment(){

    private lateinit var binding: DialogFragmentResultsBinding

    private lateinit var viewModel: ResultsBmiViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                (this as? BottomSheetDialog)?.behavior?.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ResultsBmiViewModel::class.java)
        return inflater.inflate(R.layout.dialog_fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DialogFragmentResultsBinding.bind(view)

        binding.tvNameAndResult.text

    }
}