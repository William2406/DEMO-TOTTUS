package com.tottus.ui.team

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.tottus.R
import com.tottus.databinding.DialogRegisterTeamBinding
import com.tottus.databinding.FragmentGroupBinding
import com.tottus.ui.showLongMessage
import com.tottus.ui.validateInputs
import kotlinx.android.synthetic.main.dialog_register_team.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment() {

    private lateinit var bindingFragment: FragmentGroupBinding
    private lateinit var bindingDialog: DialogRegisterTeamBinding

    private val viewModel: TeamViewModel by viewModel()
    private var dialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentGroupBinding.inflate(inflater, container, false)
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instanceDialog()
        initViewModel()
        initOnClick()
    }

    private fun initOnClick() {
        bindingFragment.saveButton.setOnClickListener {
            dialog?.show()
        }
    }

    private fun initViewModel() {
        viewModel.apply {
            showMessage.observe(viewLifecycleOwner, observerMessage())
            isSuccessful.observe(viewLifecycleOwner, observerSuccessful())
        }
    }

    private fun observerMessage() = Observer<String> {
        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
    }

    private fun observerSuccessful() = Observer<Boolean> {
        dialog?.dismiss()
    }

    private fun instanceDialog() {
        dialog = Dialog(requireContext())
        dialog?.setContentView(R.layout.dialog_register_team)
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.setCancelable(false)
        dialog?.addTeamButton?.setOnClickListener {
            val name = dialog?.teamNameText?.text.toString()
            val sentence = dialog?.sentenceText?.text.toString()
            if (validateInputs(name, sentence)) {
                viewModel.registerTeam(name, sentence)
            } else {
                showLongMessage("Existe Campos Vacios")
            }
        }
    }
}