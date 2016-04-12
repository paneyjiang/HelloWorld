package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis:redis的java客户端开发包
 * 通过jedis来和redis服务端通信，完成需要做的事情
 * @author jianglh
 *
 */
public class TestJedis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
  /* 
		//1.采用jedis连接池的方式连接redis
	  //JedisPool(org.apache.commons.pool.impl.GenericObjectPool.Config poolConfig, String host, int port) 
		JedisPoolConfig  config = new JedisPoolConfig();
		//config.setMaxActive(maxActive)
		JedisPool pclient = new JedisPool(config,"172.21.1.37",7100);
		Jedis   c = pclient.getResource();
	   // c.set("agent","test");
		System.out.println(c.get("agent"));*/
		
		
		System.out.println(new StringBuffer("abc").reverse());
	}

}
