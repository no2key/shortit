package cn.nutz.shortit;

import org.nutz.filepool.FilePool;

/**
 * 帮助类,不解释
 * @author wendal
 *
 */
public class Helper {

	public static FilePool filePool;
	
	public static String id2String(long id) {
		String val = "";
		if (id == 0)
			return "0";
		while (id > 0) {
			int p = (int)(id % 62);
			if (p < 10)
				val = "" + p + val;
			else if (p < 36)
				val = "" + (char)(p + 55) + val;
			else
				val = "" + (char)(p + 61) + val;
			id = id / 62;
		}
		return val;
	}
	
	public static long string2Id(String str) {
		long id = 0;
		for (char c : str.toCharArray()) {
			if (c < 48)
				return -1;
			if (c < 58)
				id = id * 62 + (c - 48);
			else if (c < 65)
				return -1;
			else if (c < 91)
				id = id * 62 + (c - 55);
			else if (c < 97)
				return -1;
			else if (c < 123)
				id = id * 62 + (c - 61);
			else
				return -1;
				
		}
		return id;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 65; i++) {
			System.out.println(""+i+"="+id2String(i) + "=" + string2Id(id2String(i)));
		}
	}
}
