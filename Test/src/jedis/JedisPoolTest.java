package jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

public class JedisPoolTest {
	private static JedisPool pool;

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
		pool = new JedisPool(config, bundle.getString("ip"),
				Integer.valueOf(bundle.getString("port")));

	}

	/**
	 * 返回jedis实例
	 * 
	 * @return
	 */
	public static Jedis getJedisInstance() {

		return pool.getResource();
	}

	/**
	 * 释放对象
	 * 
	 * @param clijedis
	 */
	public static void destroyJedis(Jedis clijedis) {

		pool.returnResource(clijedis);
	}

	public static void main(String[] args) {

		Jedis jedis = getJedisInstance();
		String value = jedis.get("agent");
		System.out.println(value);
		String session = jedis.get("[SESSION_INFO][TYS001|939F24741587BF340E8A3ACFE3E57AF4]");
		System.out.println(session);
		/*//Pipeline pipline = jedis.pipelined();
		//pipline.
		//jedis.del("kind_code");
		HashMap<String, String> map = new HashMap();
		map.put("53", "智能卡");
		map.put("54", "机顶盒");
		map.put("55", "宽带猫");
		//jedis.hmset("kind_code", map);
		//jedis.del("kind_code");
	//  System.out.println(jedis.hkeys("kind_code"));
		//System.out.println(jedis.hkeys("kind_code"));
		//System.out.println(jedis.hvals("kind_code"));
		Set  keys = jedis.hkeys("kind_code");
		Iterator iter = keys.iterator();
		String[] keyarr =new String[keys.size()];
		for(int i=0;iter.hasNext();i++){
			keyarr[i]=(String) iter.next();
		}
		List list = jedis.hmget("kind_code",keyarr);
	//	System.out.println(list.size());
		for(int i=0;i<list.size();i++){
		   System.out.println(list.get(i));
		}
		
		//操作list,rpush,有顺序的，lpush没有顺序
		jedis.del("list");
		jedis.rpush("list", "20001-科讯");
		jedis.rpush("list", "20002-易方达");
		jedis.rpush("list", "20003-掌上明珠");
		jedis.rpush("list", "20004-淘宝");
		jedis.rpush("list", "20005-京东");
		
	//	System.out.println(jedis.lrange("list", 0, -1));
		
		
	//set
		jedis.sadd("set", "set1");
		jedis.sadd("set", "set2");
		jedis.sadd("set", "set3");
		jedis.sadd("set", "set4");
		
	//	System.out.println(jedis.smembers("set"));
	//	System.out.println(jedis.sismember("set", "jianglh"));
	//	System.out.println(jedis.scard("set"));
		
		//sort set
		HashMap<Double,String> hmap = new HashMap<Double,String>();
		hmap.put(new Double(1), "sort1");
		hmap.put(new Double(2), "sort2");
		hmap.put(new Double(3), "sort3");
		//jedis.zadd("sortset", hmap);
	//	System.out.println(jedis.zrange("sortset", 0, -1));
		Pipeline  pipe = jedis.pipelined();
    
		for(int i=0;i<100;i++){
			pipe.set("key"+i, "value"+i);
		}
		pipe.sync();
		Pipeline  pipe = jedis.pipelined();
		pipe.get("agent");
		for(int i=0;i<100;i++){
			pipe.get("key"+i);
		}
		List returnlist = pipe.syncAndReturnAll();
		for(int i=0;i<returnlist.size();i++){
			
			System.out.println("pipe=="+returnlist.get(i));
		}
		
	//	jedis.
*/		destroyJedis(jedis);
	}
}
