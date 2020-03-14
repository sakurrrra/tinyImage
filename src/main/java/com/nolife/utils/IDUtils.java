package com.nolife.utils;

import java.util.Random;

/**
 * 各种id生成工具类
 * 
 * @author xrl（1393697381@qq.com)
 * date 2020年2月7日
 *
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		return millis + String.format("%03d", end3);
	}
}
