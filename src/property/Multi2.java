package property;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Multi2{
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		filterML();
	}
	public static void filterML() throws IOException{
		String rpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\sameAs_\\";
		String wpath="D:\\学习中\\实验室\\RDF\\Data\\Data\\sameAs_1";
		File[] filed = new File(rpath).listFiles();
		ArrayList propertyName=new ArrayList();
		for(int i = 0; i < filed.length; i++){
			String domainPath=filed[i].getPath();
			String domainname=filed[i].getName();
			String doWPath=wpath+"\\"+domainname;
			File[] files = new File(domainPath).listFiles();
			for(int j=0;j<files.length;j++){
				String entityPath=files[j].getPath();
				String entityname=files[j].getName();
				String enWPath=doWPath+"\\"+entityname;
//				System.out.println(enWPath);
				FileReader fr = new FileReader(entityPath);
				BufferedReader br = new BufferedReader(fr);
				String pre=br.readLine();
				File file=new File(enWPath);
				file.getParentFile().mkdirs();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				while(pre!=null){
					try{
//						Subject=ns[0].toString().substring(ns[0].toString().indexOf("://")+3, ns[0].toString().indexOf("/",9));
						String sub=pre.substring(10,21);
						if(sub.equals("dbpedia.org")){
							pre=br.readLine();
							continue;
						}
//						System.out.println(pre);
						bw.write(pre.toString());
						bw.newLine();
						bw.flush();
						pre=br.readLine();
					}catch(Exception e){
						pre=br.readLine();
					}
				}	
			}						
		}
	}
}
