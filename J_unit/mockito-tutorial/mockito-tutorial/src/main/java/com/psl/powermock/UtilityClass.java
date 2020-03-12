package com.psl.powermock;

public class UtilityClass {
	static int staticMethod(long value) {
		throw new RuntimeException(
				"Exception is there.");
	}
}