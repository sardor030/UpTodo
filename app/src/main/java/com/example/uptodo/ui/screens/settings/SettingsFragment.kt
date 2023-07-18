package com.example.uptodo.ui.screens.settings

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.uptodo.R
import com.example.uptodo.ui.screens.settings.dialog.ChangeLanguageDialog

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var llChangeColor: LinearLayout? = null
    private var llChangeTypography: LinearLayout? = null
    private var llChangeLanguage: LinearLayout? = null

    private val changeLanguageDialog = ChangeLanguageDialog()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.initViews()

        initListeners()
    }

    private fun View.initViews() {
        llChangeColor = findViewById(R.id.ll_change_color)
        llChangeTypography = findViewById(R.id.ll_change_typography)
        llChangeLanguage = findViewById(R.id.ll_change_language)
    }

    private fun initListeners() {
        llChangeColor?.setOnClickListener {
            //todo
        }

        llChangeTypography?.setOnClickListener {
            // todo
        }

        llChangeLanguage?.setOnClickListener {
            changeLanguageDialog.show(parentFragmentManager, changeLanguageDialog.tag)
        }
    }
}