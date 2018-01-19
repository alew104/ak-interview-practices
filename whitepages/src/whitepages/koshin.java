package whitepages;

import java.util.*;
import java.io.*;

public class koshin {
	  public static void main (String[] args){
		  	String[] a = {"5","6","0","4","2","4","1","0","0","4"};
		    String result = dragon(a);
		    System.out.println("a = " + result);
		    
		    String[] b = {"0","0","0"};
		    result = dragon(b);
		    System.out.println("b = " + result);
		    
		    String[] c = {"1","7","0"};
		    result = dragon(c);
		    System.out.println("c = " + result);
		    
		    String[] d = {"5","6","0","4","2","4","2","0","7","0"};
		    result = dragon(d);
		    System.out.println("d = " + result);
		    
		    String[] e = {"5","6","0","4","2","4","2","0","1","0"};
		    result = dragon(e);
		    System.out.println("e = " + result);
		    
		    String[] f = {"5","3","0","2","2","4","2","3","1","0"};
		    result = dragon(f);
		    System.out.println("f = " + result);
		    
		    String[] g = {"3","2","0","2","2","3","2","0","1","1"};
		    result = dragon(g);
		    System.out.println("g = " + result);
		    
		    String[] h = {"14","2","0","2","2","0","2","0","2","0"};
		    result = dragon(h);
		    System.out.println("h = " + result);
		    
		    String[] i = {"0","0","0"};
		    result = dragon(i);
		    System.out.println("i = " + result);
		    
		    String[] j = {"0"};
		    result = dragon(j);
		    System.out.println("j = " + result);
		    
		    String[] k = {"1","1","1","1"};
		    result = dragon(k);
		    System.out.println("k = " + result);
		    
		    String[] l = {"1","1","1","0"};
		    result = dragon(l);
		    System.out.println("l = " + result);
		  }

		  public static String dragon(String[] a){
		    String result = "0, "; // string to hold result
		    int pos = 0; // initial position
		    
		    if (Integer.parseInt(a[pos]) == 0) {
		    		result = "failure";
		    		return result;
		    }
		    
		    if (Integer.parseInt(a[pos]) >= a.length) {
		    		result = result + "out";
		    		return result;
		    }
		    
		    while (pos < a.length){ // while the position is less than array size
			  pos = findPos(a, pos); // update position
		      result = result + pos + ", "; // add to string
		      
		      //janky
              if ((pos + Integer.parseInt(a[pos]) >= a.length)) {
                  pos = a.length;
                  result = result + "out";
              } else if (Integer.parseInt(a[pos]) == 0) {
            	  	 pos = a.length;
            	  	 result = "failure";
              }
		    }
		    return result;
		  }
		  
		  public static int findPos(String[] a, int pos) {
		      int maxSum = pos + 1 + Integer.parseInt(a[pos + 1]); // fencepost, so that I compare with first sum
		      int limit = pos + Integer.parseInt(a[pos]); // set limit of hops i can make
		      int newPos = pos + 1; // storage variable

		      for (int i = pos + 1; i <= Math.min(limit, a.length - 1); i++){
		        int newSum = Integer.parseInt(a[i]) + i; // index of number + actual number
		        if (newSum >= maxSum && i > newPos){ // make sure that I choose furthest index while retaining largest potential
		        	  // updating new values
		          maxSum = newSum;
		          newPos = i;
		        }
		      }
		      return newPos;
		  }
}
