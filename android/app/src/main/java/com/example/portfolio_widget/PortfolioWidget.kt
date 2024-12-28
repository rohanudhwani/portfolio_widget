package com.example.portfolio_widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import es.antonborri.home_widget.HomeWidgetPlugin

/**
 * Implementation of App Widget functionality.
 */
class PortfolioWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val views = RemoteViews(context.packageName, R.layout.portfolio_widget)
    val widgetData = HomeWidgetPlugin.getData(context)

    // Get the data saved from Flutter
    val portfolioValue = widgetData.getString("portfolioValue", "0.0") ?: "0.0"
    val investedValue = widgetData.getString("investedValue", "0.0") ?: "0.0"
    val dayPNLValue = widgetData.getString("dayPNLValue", "0.0") ?: "0.0"
    val dayPNLPercent = widgetData.getString("dayPNLPercent", "0.0") ?: "0.0"
    val unrealisedPNLValue = widgetData.getString("unrealisedPNLValue", "0.0") ?: "0.0"
    val unrealisedPNLPercent = widgetData.getString("unrealisedPNLPercent", "0.0") ?: "0.0"
    val realisedPNLValue = widgetData.getString("realisedPNLValue", "0.0") ?: "0.0"
    val realisedPNLPercent = widgetData.getString("realisedPNLPercent", "0.0") ?: "0.0"

    // Update the widget views with the fetched data
    views.setTextViewText(R.id.portfolioValue, portfolioValue)
    views.setTextViewText(R.id.investedValue, investedValue)
    views.setTextViewText(R.id.dayPNLValue, dayPNLValue)
    views.setTextViewText(R.id.dayPNLPercent, dayPNLPercent)
    views.setTextViewText(R.id.unrealisedPNLValue, unrealisedPNLValue)
    views.setTextViewText(R.id.unrealisedPNLPercent, unrealisedPNLPercent)
    views.setTextViewText(R.id.realisedPNLValue, realisedPNLValue)
    views.setTextViewText(R.id.realisedPNLPercent, realisedPNLPercent)

    // Update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
