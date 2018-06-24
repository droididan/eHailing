package com.ehailing.ehailing.common

import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import org.joda.time.DateTime
import java.util.*


fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadFromRes(resource: Int) =
        Glide.with(this.context.applicationContext)
                .load(resource)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(this)

fun snackBar(view: View, message: String) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

fun DateTime.formatPretty() : String {
    val updateTime = this.plusMinutes(updateRandomETA())?.millis ?: 0
    val diff = updateTime - DateTime.now().millis
    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    return if (hours > 0) "${hours}h ${minutes - (hours * 60)}m" else "${minutes}m"
}

// Generate random number between -4 to 10
fun updateRandomETA() = Random().nextInt(10 + 1 + 4) - 4;