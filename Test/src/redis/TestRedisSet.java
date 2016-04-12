package redis;

import redis.clients.jedis.Jedis;

import com.pojo.User;

/**
 * 
 * @author jianglh
 * 
 */
public class TestRedisSet {
	public static void main(String[] args) {
   Jedis  client = new Jedis("172.21.1.37",6378);
 
    // client.lpush("mylist", "a","b","c","d","e");
     
     System.out.println(client.lrange("mylist", 0, -1));
	}
}
