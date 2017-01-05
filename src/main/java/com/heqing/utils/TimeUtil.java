package com.heqing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getTime(long time) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return sdf.format(new Date(time));
	}
}
