package com.jpkc.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * ID生成器
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 */
public final class IDMaker {

	// 使用队列缓存 ID （缓存 10000 ~ 15000 个）
	private volatile static Queue<Integer> ids;

	static {
		// ConcurrentLinkedQueue: 基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。
		ids = new ConcurrentLinkedQueue<Integer>();
	}

	private IDMaker() {
		// 私有化构造方法
	}

	// 构造ID，缓存 10000 ~ 15000 个。
	public static final Long make() {
		// 当队列中的 ID 数量少于 5000 个时，则随机生成 10000 个
		if (ids.size() < 5000) {
			synchronized (IDMaker.class) {
				if (ids.size() < 5000) {
					// 随机生成 10000 个 0 ~ 99999 的数字
					Set<Integer> set = new HashSet<Integer>();
					Random random = new Random();
					while (set.size() < 10000) {
						set.add(random.nextInt(100000));
					}
					// 移除队列中的 ID，保证 5000 个内不会重复
					set.removeAll(ids);
					ids.addAll(set);
				}
			}
		}
		// 获取并移除此队列的头
		return format(ids.poll());
	}

	// 格式化 ID
	private static final Long format(Integer id) {
		// 当前时间毫秒（1970 年 1 月 1 日至今）
		long time = (new Date()).getTime();
		// 格式化，当前时间毫秒拼接 ID ，如果 ID 不足 5 位在前面补零
		String str = time + String.format("%05d", id);
		// 转为 Long 类型
		return Long.parseLong(str);
	}

}
