import java.util.Arrays;
public class SampleString {

	public static void main(String[] args) {
		
		String line=System.console().readLine();
		System.out.println("Input Line:-"+line);
		String[] words =line.split(" ");
		System.out.println("Output Words:-"+Arrays.toString(words));
		
	

		
	}

}