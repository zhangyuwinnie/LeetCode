import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuffer;
public class GeneralizedAbbreviation {
	// solution1: 分解为3部分 + recursive
	public List<String> generate(String word) {
		int len = word.length();
		List<String> result = new ArrayList<String>();
		if (len== 0) return result;
		result = dfs(word);
		return result;
	}
	public List<String> dfs(String word){
		List<String> result = new ArrayList<String>();
		result.add(word); //!!!添加自己，因为后面的处理中没有将全字母的包括进去，j至少是1，第一个for循环外层没有add to list的处理
		int len = word.length();
		// i个字符开头
		for (int i = 0; i<len; i++){
			String a = word.substring(0,i);
			// 连续跟着j个数字，j至少为1，否则等同于i+1个字符
			for (int j = 1; j <= len-i ; j++){ // !!! i=0时，a是空字符串，j可以取到len-i
				String b = String.valueOf(j);
				
				// 剩余部分又是一个sub问题，但要注意必须以字母开头，所以先把head提取出来
				if (i+j<len){ //如果等于len，剩余部分为null
					String head = word.substring(i+j,i+j+1);
					if (i+j+1<len){
						List<String> tail = dfs(word.substring(j+i+1));
						for (String str : tail){
							String last = head+str;
							String item = a + b+ last;
							result.add(item);
						}
					}
					else{ //!!!不要忘记加else处理
						String item = a+b+head; 
						result.add(item);
					}				
				}
				else{   //!!!不要忘记加else处理
					String item1 = a+b;
					result.add(item1);
				}
			}			
		}
		return result;
	}
	
	// solution 2: 每个pos分为保留不保留两种处理，然后pos+1，处理到结尾，输出结果
	public List<String> generate2(String word) {
		int len = word.length();
		List<String> result = new ArrayList<String>();
		if (len== 0) return result;
		dfs2(word,0,0,new StringBuffer(), result);
		return result;
	}
	public void dfs2(String word, int pos, int count, StringBuffer sb, List<String> result){
		int len = word.length();
		int sbOriginSize = sb.length();
		if (pos==len){
			if (count >0){
				sb.append(count);
			}
			result.add(sb.toString());
			System.out.println(result);
			
		}
		if (pos<len){ //!!! 忘记判断，陷入死循环
			// 简写word[pos]
			dfs2(word, pos+1, count+1, sb, result); //!!!pos+1到终点为len，pos就理解为index就行了
			// 不简写
			if (count > 0){ //!!!
				sb.append(count);
			}
			sb.append(word.substring(pos,pos+1)); //!!!
			dfs2(word, pos+1, 0, sb, result);
		}
		sb.setLength(sbOriginSize); //!!!  ?
	}

	public static void main(String[] args){
		String s = "wo";
		GeneralizedAbbreviation test = new GeneralizedAbbreviation();
		System.out.println(test.generate(s));
		System.out.println(test.generate2(s));
	}
}
