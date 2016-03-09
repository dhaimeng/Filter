package property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getProper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		predicate();
	}
	public static void predicate(){
		String rmodepath="./data\\filmTriple1952.txt";
		int num=0;
		try{
			FileReader fr = new FileReader(rmodepath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
				String str[]=pre.split(" ");
				String Predicate=str[1].toString();
				if(Predicate.contains("<http")==true){
					System.out.println(Predicate);
					num++;
				}			
				pre=br.readLine();
			}
		}catch(Exception e){
			System.out.println("File not find!");
		}
		System.out.println(num);
	}
}
