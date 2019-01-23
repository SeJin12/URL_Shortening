import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		_URL ret = new _URL();
		
		Scanner sc = new Scanner(System.in);
		String url = sc.nextLine();
		
		
		String output = ret.shortCut(url);
		
		
		System.out.println(output.substring(1, output.length()-1)); // 양쪽 " " 제거

		sc.close();
	}
}
