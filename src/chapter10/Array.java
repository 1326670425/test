package chapter10;
import java.util.Arrays;
public class Array {
	public static void main(String[] args){
		int age[] = {18,22,20,24,28};
		int temp[] = {18,20,22,28,24};
		String words[] = {"good","well","hello","world"};
		System.out.println("����֮ǰ��"+Arrays.toString(age));
		Arrays.sort(age);
		System.out.println("����֮��"+Arrays.toString(age));
		int index = Arrays.binarySearch(age, 22)+1;//Ӧ�ô˲��ҷ���֮ǰ�����Ƚ�������
		System.out.println("����22��λ��Ϊ��"+index);
		//Arrays.sort(temp);
		System.out.println("����Ƚϣ�"+Arrays.equals(age, temp));
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
		int arr[] = new int[6];
		Arrays.fill(arr, 99);
		System.out.println(Arrays.toString(arr));
	}
}
