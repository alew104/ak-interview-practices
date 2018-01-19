
public class googleinterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "abcd";
		String b = "abcdabcd";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "abcd";
		b = "cdabcdab";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "abcd";
		b = "c";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "ab";
		b = "ab";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "ab";
		b = "ba";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "abcd";
		b = "cdbacdba";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "ccaa";
		b = "aacc";
		System.out.println(shawnSubStrOf(a,b));
		
		a = "abab";
		b = "abbab";
		System.out.println(shawnSubStrOf(a,b));

	}	
	
	public static int shawnSubStrOf(String a, String b) {
		int size = 1;
		String multiple = a;
		while (size <= ((b.length() / a.length()) + 1)) {
			if (multiple.contains(b)) {
				return size;
			} else {
				size++;
				multiple += a;
			}
		}
		return -1;
	}
}
