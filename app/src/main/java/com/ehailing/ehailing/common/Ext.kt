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


// use this to avoid layout inflater boilerplate
fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

// load resource files with Glide
fun ImageView.loadFromRes(resource: Int) =
        Glide.with(this.context.applicationContext)
                .load(resource)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(this)

// show snackBar
fun snackBar(view: View, message: String) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

// show the ETA time formatted pretty
fun Long.formatPretty() : String {
    val diff = this - DateTime.now().millis
    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60

    // format the string with/without hours
    return if (hours > 0) "${hours}h ${minutes - (hours * 60)}m" else "${minutes}m"
}

// pick randomly between 6 and -6
fun updateRandomETA() = Random().nextInt(6 + 1 + 6) - 6