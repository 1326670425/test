/**
 * @Title RedisTest.java
 * @Package 
 * @Description TODO
 * @author 吴扬颉
 * @date 2019年5月8日
 * @version 1.0
 */

import java.util.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @author 吴扬颉
 * @date 2019年5月8日
 * 
 */
public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.select(0);
		long l = jedis.zcount("未央路", "-inf", "+inf");
		System.out.println(l);
		l = jedis.zcard("未央路");
		System.out.println(l);
		
		Set<Tuple> set = jedis.zrevrangeByScoreWithScores("未央路", "+inf", "-inf");
		for(Tuple s : set){
			System.out.println(s.getElement() + " " + (int)s.getScore());
			l += s.getScore();
		}
		System.out.println(l);
		jedis.select(1);
		set = jedis.zrevrangeByScoreWithScores("串串香", "+inf", "-inf");
		for(Tuple s : set){
			System.out.println(s.getElement() + " " + (int)s.getScore());
			l += s.getScore();
		}
		System.out.println(l);

		/*	
		System.out.println(jedis.ping());
		// string
		jedis.set("name", "吴扬颉");
		System.out.println(jedis.get("name"));
		System.out.println(jedis.del("name"));
		System.out.println(jedis.get("name"));
		// list
		jedis.lpush("list", "1");
		jedis.lpush("list", "2");
		jedis.lpush("list", "3");
		List<String> list = jedis.lrange("list", 0, 2);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		jedis.lpop("list");
		jedis.lpop("list");
		jedis.lpop("list");
		// key
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		// hash
		// zset
		// set
		*/
	}
}
