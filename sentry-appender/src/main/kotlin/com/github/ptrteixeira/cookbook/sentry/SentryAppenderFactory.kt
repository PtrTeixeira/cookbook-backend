package com.github.ptrteixeira.cookbook.sentry

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.Appender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.core.filter.Filter
import com.fasterxml.jackson.annotation.JsonTypeName
import io.dropwizard.logging.AbstractAppenderFactory
import io.dropwizard.logging.async.AsyncAppenderFactory
import io.dropwizard.logging.filter.LevelFilterFactory
import io.dropwizard.logging.layout.LayoutFactory
import io.sentry.logback.SentryAppender

@JsonTypeName("sentry")
class SentryAppenderFactory : AbstractAppenderFactory<ILoggingEvent>() {

    override fun build(
        context: LoggerContext,
        applicationName: String,
        layoutFactory: LayoutFactory<ILoggingEvent>,
        levelFilterFactory: LevelFilterFactory<ILoggingEvent>,
        asyncAppenderFactory: AsyncAppenderFactory<ILoggingEvent>
    ): Appender<ILoggingEvent> {
        val appender = SentryAppender()
        appender.name = "sentry-appender"
        appender.context = context

        val layoutEncoder = LayoutWrappingEncoder<ILoggingEvent>()
        layoutEncoder.layout = buildLayout(context, layoutFactory)
        val filter: Filter<ILoggingEvent> = levelFilterFactory
            .build(threshold)
        filterFactories.forEach {
            appender.addFilter(it.build())
        }

        appender.addFilter(filter)
        appender.start()

        return wrapAsync(appender, asyncAppenderFactory)
    }
}