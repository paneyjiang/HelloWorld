package jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

/**
 * 分布式的群集使用方式
 * 
 * @author jianglh
 * 
 */
public class JedisShardPoolTest {

	private static ShardedJedisPool pool;
	// 静态初始化连接池对象
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jedispoolconfig");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[jedispoolconfig.properties] is not found!");
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.valueOf(bundle
				.getString("jedis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(bundle
				.getString("jedis.pool.maxIdle")));
		config.setMaxWait(Integer.valueOf(bundle
				.getString("jedis.pool.maxWait")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("jedis.pool.testOnReturn")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("jedis.pool.testOnBorrow")));
		// 分片
		List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
		// A主机
		JedisShardInfo shardA = new JedisShardInfo(
				bundle.getString("sharda_ip"), Integer.valueOf(bundle
						.getString("sharda_port")));
		// B主机
		 JedisShardInfo shardB = new JedisShardInfo(
		 bundle.getString("shardb_ip"), Integer.valueOf(bundle
		 .getString("shardb_port")));
		// C主机
		JedisShardInfo shardC = new JedisShardInfo(
		 bundle.getString("shardc_ip"), Integer.valueOf(bundle
		 .getString("shardc_port")));
		list.add(shardA);
		 list.add(shardB);
		 list.add(shardC);
		pool = new ShardedJedisPool(config, list, Hashing.MURMUR_HASH,
				Sharded.DEFAULT_KEY_TAG_PATTERN);

	}

	/**
	 * 返回jedis实例
	 * 
	 * @return
	 */
	public static ShardedJedis getJedisInstance() {

		return pool.getResource();
	}

	/**
	 * 释放对象
	 * 
	 * @param clijedis
	 */
	public static void destroyJedis(ShardedJedis clijedis) {

		pool.returnResource(clijedis);
	}

	public static void main(String[] args) {

		// test

		ShardedJedis jedis = getJedisInstance();
	//	jedis.set("shard14", "test value14");
		jedis.set("shard13", "test value13");
		System.out.println(jedis.get("shard14")+","+jedis.getShard("shard14"));
	/*	for (int i = 1; i < 20; i++) {
			System.out.println(jedis.get("shard" + i) + ",ip=="
					+ jedis.getShardInfo("shard" + i));
		}*/

	}

}
