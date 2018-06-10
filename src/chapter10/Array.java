package chapter10;
import java.util.Arrays;
public class Array {
	public static void main(String[] args){
		int age[] = {18,22,20,24,28};
		int temp[] = {18,20,22,28,24};
		String words[] = {"good","well","hello","world"};
		System.out.println("排序之前："+Arrays.toString(age));
		Arrays.sort(age);
		System.out.println("排序之后："+Arrays.toString(age));
		int index = Arrays.binarySearch(age, 22)+1;//应用此查找方法之前必须先进行排序
		System.out.println("年龄22的位置为："+index);
		//Arrays.sort(temp);
		System.out.println("数组比较："+Arrays.equals(age, temp));
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
		int arr[] = new int[6];
		Arrays.fill(arr, 99);
		System.out.println(Arrays.toString(arr));
	}
}
