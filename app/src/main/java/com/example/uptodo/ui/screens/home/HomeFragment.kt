package com.example.uptodo.ui.screens.home


import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uptodo.R
import com.example.uptodo.mock.HomeMockito
import com.example.uptodo.ui.screens.home.lists.PriorityAdapter
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

    @SuppressLint("InflateParams")
    private fun openBottomSheet() {

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.bottom_sheet_home, null)
        bottomSheetDialog.setContentView(view)

        val bottomSheetView =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheetView?.setBackgroundResource(R.drawable.bg_home_bottom_sheet)
        bottomSheetDialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        val ivPriority = view.findViewById<ImageView>(R.id.iv_priority)
        val ivTime = view.findViewById<ImageView>(R.id.iv_timer)

        ivPriority.setOnClickListener {
            openPriorityDialog()
        }

        ivTime.setOnClickListener {
            openDatePicker()
        }

        bottomSheetDialog.show()
    }

    @SuppressLint("InflateParams", "MissingInflatedId")
    private fun openPriorityDialog() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val view = layoutInflater.inflate(R.layout.dialog_task_priority, null)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val rvPriority = view.findViewById<RecyclerView>(R.id.rv_priority)
        val adapter = PriorityAdapter()
        adapter.list = HomeMockito.priorityList
        rvPriority.adapter = adapter

        dialog.setView(view)
        dialog.show()
    }

    @SuppressLint("CutPasteId")
    private fun openDatePicker() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val view = layoutInflater.inflate(R.layout.dialog_date_picker, null)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnTime = view.findViewById<TextView>(R.id.tv_time)
        val tvCancel = view.findViewById<TextView>(R.id.tv_cancel)
        btnTime.setOnClickListener {
            openTimePicker()
            dialog.dismiss()
        }

        tvCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setView(view)
        dialog.show()
    }

    private fun openTimePicker() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val view = layoutInflater.inflate(R.layout.dialog_time_picker, null)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvSave = view.findViewById<TextView>(R.id.tv_save)
        val tvCancel = view.findViewById<TextView>(R.id.tv_cancel)
        tvSave.setOnClickListener {

        }

        tvCancel.setOnClickListener {
            dialog.cancel()
        }

        dialog.setView(view)
        dialog.show()
    }
}