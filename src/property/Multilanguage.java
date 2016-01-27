package property;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Multilanguage {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		filterML();
	}
	public static void filterML() throws IOException{
		String rpath="D:\\学习中\\实验室\\RDF\\Data\\sameAs_\\";
		File[] filed = new File(rpath).listFiles();
		System.out.println(filed.length);
		ArrayList propertyName=new ArrayList();
		for(int i = 0; i < filed.length; i++){
			String domainPath=filed[i].getPath();
			File[] files = new File(domainPath).listFiles();
			System.out.println(files.length);
			for(int j=0;j<files.length;i++){
				String triplePath=files[i].getPath();
				FileReader fr = new FileReader(triplePath);
				BufferedReader br = new BufferedReader(fr);
				String pre=br.readLine();
				try{
//					Subject=ns[0].toString().substring(ns[0].toString().indexOf("://")+3, ns[0].toString().indexOf("/",9));
					String sub=pre.substring(10,21);
					if(sub.equals("dbpedia.org")){
						//continue;
						System.out.println(pre);
						System.out.println(triplePath);
					}
//					System.out.println(pre);
					pre=br.readLine();
				}catch(Exception e){
					pre=br.readLine();
				}
			}			
			
		}
	}
}
