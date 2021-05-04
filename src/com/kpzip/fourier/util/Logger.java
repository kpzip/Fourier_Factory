package com.kpzip.fourier.util;

public class Logger {
	private static final String ANSI_RED    = "\u001B[31m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLACK  = "\u001B[30m";
	private static final String ANSI_RESET  = "\u001B[0m";
	
	public static void log(String message) {
		System.out.println(message);
	}
	public static void log(LoggerType type, String message) {
		switch(type) {
		case INFO:
			System.out.println(ANSI_BLACK + message + ANSI_RESET);
			break;
		case WARNING:
			System.out.println(ANSI_YELLOW + message + ANSI_RESET);
			break;
		case ERROR:
			System.out.println(ANSI_RED + message + ANSI_RESET);
			break;
		}
	}
}
