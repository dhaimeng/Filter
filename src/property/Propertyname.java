package property;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Propertyname {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getproperty();
	}
	public static void getproperty() throws IOException{
		String rpath="C:\\Users\\dhm\\Desktop\\entity_dhm\\";
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
					String Predicate=ns[1].toString().replace("<", "").replace(">", "");
					if(propertyName.indexOf(Predicate)==-1){
						propertyName.add(Predicate);
					}
					pre =br.readLine();
				}catch(Exception e){
//					System.out.println("@@"+pre+"µÚ"+triplePath);
					pre =br.readLine();
				}
				
			}
			
		}
		System.out.println(propertyName.size());
		String wpath="C:\\Users\\dhm\\Desktop\\location.txt";
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
