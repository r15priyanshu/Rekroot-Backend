package com.anshuit.rekroot.utils;

import java.util.Objects;

import com.anshuit.rekroot.enums.ApiResponseDetailsEnum;
import com.anshuit.rekroot.enums.ErrorResponseDetailsEnum;

public class CustomUtil {
	public static String getFormattedErrorMessage(ErrorResponseDetailsEnum errorResponseDetailsEnum, Object... args) {
		return getFormattedMessage(errorResponseDetailsEnum.getErrorMessage(), args);
	}

	public static String getFormattedApiResponseMessage(ApiResponseDetailsEnum apiResponseEnum, Object... args) {
		return getFormattedMessage(apiResponseEnum.getMessage(), args);
	}

	private static String getFormattedMessage(String message, Object... args) {
		if (Objects.isNull(args) || args.length == 0)
			return message;
		return String.format(message, args);
	}
}
