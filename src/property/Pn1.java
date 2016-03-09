package property;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 获取6个领域的属性名称
 * @author dhm
 *
 */
public class Pn1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String rpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\entity_p\\";
		String wpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\entity_p1\\";
		String s="book,location,person,song,film,organization";
//		String s="organization,location";
 		String[] str=s.split(",");
//		for(int i=0;i<str.length;i++){
//			getp(rpath+str[i].toString(),wpath+str[i].toString()+".txt");
//			System.out.println(rpath+str[i].toString()+"------"+wpath+str[i].toString()+".txt");
//		}
 		getp("./data\\filmTriple1952.txt","aa.txt");
	}
	public static void getp(String rpath,String wpath) throws IOException{
//		String rpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\entity_p\\location";
		File[] files = new File(rpath).listFiles();
		ArrayList propertyName=new ArrayList();
		for(int i = 0; i < files.length; i++){
			String triplePath=files[i].getPath();
			FileReader fr = new FileReader(triplePath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
				String[]ns=pre.split(" ");
				try{
					String Predicate=ns[1].toString();
					if(Predicate.contains("<http")==true){
						if(propertyName.indexOf(Predicate)==-1){
							propertyName.add(Predicate);
						}
					}					
					pre =br.readLine();
				}catch(Exception e){
//					System.out.println("@@"+pre+"第"+triplePath);
					pre =br.readLine();
				}
				
			}
			
		}
		System.out.println(propertyName.size());
//		String wpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\entity_p1\\location.txt";
		FileWriter fw = new FileWriter(wpath,false);
	    BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0;i<propertyName.size();i++){
//			System.out.println(propertyName.get(i));
			String str=propertyName.get(i).toString();
			bw.write(str);
			bw.newLine();
		    bw.flush();
		}  	 	
	}

}

