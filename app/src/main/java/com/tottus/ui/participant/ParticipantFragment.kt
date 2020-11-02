package com.tottus.ui.participant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tottus.R
import com.tottus.databinding.FragmentParticipantBinding
import com.tottus.ui.showLongMessage
import com.tottus.ui.validateInputs
import kotlinx.android.synthetic.main.bottomsheet_participant.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ParticipantFragment : Fragment() {

    private lateinit var bindingFragment: FragmentParticipantBinding

    private val viewModel: ParticipantViewModel by viewModel()
    private var dialog: BottomSheetDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentParticipantBinding.inflate(inflater, container, false)
        return bindingFragment.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnClick()
        instanceDialog()
    }

    private fun initViewModel() {
        viewModel.apply {
            showMessage.observe(this@ParticipantFragment, observerMessage())
            isSuccessful.observe(this@ParticipantFragment, observerSuccessful())
        }
    }

    private fun initOnClick() {
        bindingFragment.saveButton.setOnClickListener {
            dialog?.show()
        }
    }

    private fun observerMessage() = Observer<String> {
        showLongMessage(it)
    }

    private fun observerSuccessful() = Observer<Boolean> {
        dialog?.dismiss()
    }

    private fun instanceDialog() {
        val dialogView: View = layoutInflater.inflate(R.layout.bottomsheet_participant, null)
        dialog = BottomSheetDialog(requireContext())
        dialog?.setContentView(dialogView)
        dialog?.addParticipantButton?.setOnClickListener {
            val names = dialog?.participantNameText?.text.toString()
            val lastNames = dialog?.lastNameText?.text.toString()
            if (validateInputs(names, lastNames)) {
                viewModel.registerParticipant(names, lastNames)
            } else {
                showLongMessage("Existen Campos vacios")
            }
        }
    }

}