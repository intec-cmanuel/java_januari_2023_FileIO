package be.intecbrussel.simpleblog.service;

import be.intecbrussel.simpleblog.data.LoggingRepository;
import be.intecbrussel.simpleblog.model.LogLevel;

public class LoggingService {
    private LoggingRepository loggingRepository = new LoggingRepository();
    private LogLevel levelToLog = LogLevel.NONE;

    private void log(String message) {
        loggingRepository.log(message);
    }

    private void log(Exception exception, LogLevel level) {
        StringBuilder toLog = new StringBuilder();
        toLog.append(level + ": " + exception.getMessage() + "\n");

        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceLine = stackTraceElement.toString();
            toLog.append(stackTraceLine).append("\n");
        }

        log(toLog.toString());
    }

    public void debug(Exception exception) {
        if (levelToLog != LogLevel.DEBUG) {
            return;
        }

        log(exception, LogLevel.DEBUG);
    }

    public void warn(Exception exception) {
        if (levelToLog == LogLevel.ERROR || levelToLog == LogLevel.NONE) {
            return;
        }

        log(exception, LogLevel.WARNING);
    }

    public void error(Exception exception) {
        if (levelToLog == LogLevel.NONE) {
            return;
        }

        log(exception, LogLevel.ERROR);
    }
}
