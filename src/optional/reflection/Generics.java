package optional.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
class CustomMap<T, R> {
	ArrayList<T> keys;
	ArrayList<R> value;
	
	public <R> void get(T key) {
		return;
	}
}

public class Generics {
	public static void main(String[] args) {
		//@formatter:off
		Arrays.compare(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8});
		System.out.println(
			Arrays.compare(
			new Integer[]{1, 2, 3, 4},
			new Integer[]{1, 2, 3, 2},
		      (o1,o2)-> {
		          if(o1 > o2) {
		              return 1;
		          } else if(o1 < o2) {
		              return -1;
		          }
		          
		          return 0;
		      }
		  )
		);
	}
}

