package com.tottus.ui.team

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tottus.R
import com.tottus.databinding.DialogRegisterTeamBinding
import com.tottus.databinding.FragmentGroupBinding
import com.tottus.domain.entity.TeamDomain
import com.tottus.ui.showLongMessage
import com.tottus.ui.validateInputs
import kotlinx.android.synthetic.main.dialog_register_team.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment() {

    private lateinit var bindingFragment: FragmentGroupBinding
    private lateinit var bindingDialog: DialogRegisterTeamBinding

    private val adapter: TeamAdapter by inject()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instanceDialog()
        initRecyclerView()
        initOnClick()
    }

    private fun initRecyclerView() {
        bindingFragment.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        bindingFragment.recyclerView.adapter = adapter
    }

    private fun initOnClick() {
        bindingFragment.saveButton.setOnClickListener {
            dialog?.show()
        }

        adapter.onClick = TeamAdapter.OnClick {
            view?.findNavController()?.navigate(R.id.action_nav_group_to_participantFragment)
        }
    }

    private fun initViewModel() {
        viewModel.apply {
            showMessage.observe(this@TeamFragment, observerMessage())
            isSuccessful.observe(this@TeamFragment, observerSuccessful())
            showAllTeams.observe(this@TeamFragment, observerTeams())
            getAllTeams()
        }
    }

    private fun observerTeams() = Observer<MutableList<TeamDomain>> {
        adapter.teamList = it
        adapter.notifyDataSetChanged()
    }

    private fun observerMessage() = Observer<String> {
        showLongMessage(it)
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
                viewModel.getAllTeams()
            } else {
                showLongMessage("Existe Campos Vacios")
            }
        }
    }

}