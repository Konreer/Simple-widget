package com.smb5.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.smb5.R

import android.app.PendingIntent

import android.content.Intent
import com.smb5.activity.Image
import com.smb5.activity.Sound
import com.smb5.activity.Web


/**
 * Implementation of App Widget functionality.
 */
class Widget : AppWidgetProvider() {
    private val INTENT_FLAGS = 0
    private val REQUEST_CODE = 0

    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray?
    ) {
        val controlButtons = RemoteViews(
            context.packageName,
            R.layout.widget
        )
        val soundIntent = Intent(context, Sound::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val imageIntent = Intent(context, Image::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val webIntent = Intent(context, Web::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val soundPendingIntent = PendingIntent.getActivity(
            context, REQUEST_CODE, soundIntent, INTENT_FLAGS
        )
        val imagePendingIntent = PendingIntent.getActivity(
            context, REQUEST_CODE, imageIntent, INTENT_FLAGS
        )
        val webPendingIntent = PendingIntent.getActivity(
            context, REQUEST_CODE, webIntent, INTENT_FLAGS
        )
        controlButtons.setOnClickPendingIntent(
            R.id.button_sound, soundPendingIntent
        )
        controlButtons.setOnClickPendingIntent(
            R.id.button_image, imagePendingIntent
        )
        controlButtons.setOnClickPendingIntent(
            R.id.button_web, webPendingIntent
        )
        appWidgetManager.updateAppWidget(appWidgetIds, controlButtons)
    }
}