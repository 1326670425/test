/**
 * @Title RedisTest.java
 * @Package 
 * @Description TODO
 * @author �����
 * @date 2019��5��8��
 * @version 1.0
 */

import java.util.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @author �����
 * @date 2019��5��8��
 * 
 */
public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.select(0);
		long l = jedis.zcount("δ��·", "-inf", "+inf");
		System.out.println(l);
		l = jedis.zcard("δ��·");
		System.out.println(l);
		
		Set<Tuple> set = jedis.zrevrangeByScoreWithScores("δ��·", "+inf", "-inf");
		for(Tuple s : set){
			System.out.println(s.getElement() + " " + (int)s.getScore());
			l += s.getScore();
		}
		System.out.println(l);
		jedis.select(1);
		set = jedis.zrevrangeByScoreWithScores("������", "+inf", "-inf");
		for(Tuple s : set){
			System.out.println(s.getElement() + " " + (int)s.getScore());
			l += s.getScore();
		}
		System.out.println(l);

		/*	
		System.out.println(jedis.ping());
		// string
		jedis.set("name", "�����");
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
