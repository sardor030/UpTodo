package com.example.uptodo.ui.screens.settings.dialog

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.uptodo.R

class ChangeLanguageDialog : DialogFragment(R.layout.dialog_change_language) {

    var onAcceptClick: (() -> Unit)? = null

    private var btnCancel: Button? = null
    private var btnOk: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.initViews()
        initListeners()
    }

    private fun View.initViews() {
        btnCancel = findViewById(R.id.btn_dialog_cancel)
        btnOk = findViewById(R.id.btn_dialog_ok)
    }

    private fun initListeners() {
        btnCancel?.setOnClickListener { dismiss() }
        btnOk?.setOnClickListener { onAcceptClick?.invoke() }
    }

}