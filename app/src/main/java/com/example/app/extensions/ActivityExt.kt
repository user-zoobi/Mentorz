package com.metro.metroestore.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProvider.NewInstanceFactory().create(viewModelClass)

fun <T : AppCompatActivity> AppCompatActivity.gotoActivity(targetActivityClass: Class<T>) {
    val intent = Intent(this, targetActivityClass)
    startActivity(intent)
}

fun AppCompatActivity.gotoActivityWithNoHistory(targetActivityClass: Class<*>) {
    val i = Intent(this, targetActivityClass)
    i.flags =
        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(i)
}

fun AppCompatActivity.gotoActivity(
    targetActivityClass: Class<*>,
    intentKey: String,
    intentValue: Any? = null
) {
    val i = Intent(this, targetActivityClass)
    i.putExtra(intentKey, intentValue)
    startActivity(i)
}

fun AppCompatActivity.gotoActivity(
    targetActivityClass: Class<*>,
    intentKey1: String,
    intentValue1: Any? = null,
    intentKey2: String,
    intentValue2: Any? = null
) {
    val i = Intent(this, targetActivityClass)
    i.putExtra(intentKey1, intentValue1)
    i.putExtra(intentKey2, intentValue2)
    startActivity(i)
}

fun AppCompatActivity.gotoActivity(
    targetActivityClass: Class<*>,
    intentKey1: String,
    intentValue1: Any? = null,
    intentKey2: String,
    intentValue2: Any? = null,
    intentKey3: String,
    intentValue3: Any? = null
) {
    val i = Intent(this, targetActivityClass)
    i.putExtra(intentKey1, intentValue1)
    i.putExtra(intentKey2, intentValue2)
    i.putExtra(intentKey3, intentValue3)
    startActivity(i)
}
