package com.example.uptodo.ui.screens.home


import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uptodo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var bottomNav: BottomNavigationView? = null
    private var btnAdd: FloatingActionButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initNavGraph()

        initListener()
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

    private fun initListener() {

        btnAdd?.setOnClickListener { openBottomSheet() }
    }

    private fun openBottomSheet() {

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_home)

        val bottomSheetView =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheetView?.setBackgroundResource(R.drawable.bg_home_bottom_sheet)
        bottomSheetDialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        bottomSheetDialog.show()
    }

}