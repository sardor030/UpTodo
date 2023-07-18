package com.example.uptodo.ui.screens.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uptodo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var bottomNav: BottomNavigationView? = null
    private var btnAdd: FloatingActionButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initNavGraph()
    }

    private fun initViews() {
        bottomNav = view?.findViewById(R.id.bottom_nav)
        btnAdd = view?.findViewById(R.id.btn_add)
    }

    private fun initNavGraph() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        val navController = navHostFragment?.navController
        navController?.let { bottomNav?.setupWithNavController(it) }
    }


}