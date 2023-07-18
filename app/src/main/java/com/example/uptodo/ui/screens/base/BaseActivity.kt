package com.example.uptodo.ui.screens.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

abstract class BaseActivity(private val layoutRes: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        initialize()
    }

    abstract fun initialize()

    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resource = context.resources
        val configuration = resource.configuration
        configuration.locale = locale
        resource.updateConfiguration(configuration, resource.displayMetrics)
    }
}