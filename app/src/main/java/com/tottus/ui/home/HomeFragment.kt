package com.tottus.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tottus.databinding.FragmentHomeBinding
import com.tottus.domain.entity.UserDomain
import com.tottus.ui.HomeActivity

class HomeFragment : Fragment() {

    private lateinit var bindingFragment: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentHomeBinding.inflate(inflater, container, false)
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val userDomain = (activity as HomeActivity).getUserDomain()
        bindingFragment.namesText.text = userDomain.names
        bindingFragment.emailText.text = userDomain.email
    }
}