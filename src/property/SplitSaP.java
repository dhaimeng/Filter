package property;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SplitSaP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap property=readModel();
		mapping(property);
	}
	public static HashMap readModel(){
		String rmodepath="C:\\Users\\dhm\\Desktop\\hexie_model\\filmmodel.txt";			
		HashMap property=new HashMap();
		ArrayList triple=new ArrayList();		
		try{
			FileReader fr = new FileReader(rmodepath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
//				System.out.println(pre);
				if(pre.contains("<oneobject")){
					String lable=pre;
					ArrayList predicate=new ArrayList();
					pre=br.readLine();
					while(pre.contains("<oneobject")==false){
						predicate.add(pre);
						pre=br.readLine();
						if(pre==null){
							break;
						}
					}
					property.put(lable, predicate);		
//					System.out.println(lable);
				}
			}
		}catch(Exception e){
			System.out.println("model not find!");
		}
//		/*输出标签列表*/
//		Object[] key = property.keySet().toArray(); 
//		for(int i = 0; i<key.length; i++)
//		{  
//		     System.out.println(key[i]);  
//		     System.out.println(property.get(key[i]));  
//		}
		return property;
	}
	public static void mapping(HashMap property){
		/*输出标签列表*/
		String rtxt="C:\\Users\\dhm\\Desktop\\hexie_model\\aa.txt";
		String wtxt="C:\\Users\\dhm\\Desktop\\hexie_model\\aa1.txt";
		ArrayList orgintxt=new ArrayList();
		try{
			FileReader fr = new FileReader(rtxt);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
				orgintxt.add(pre);
				pre=br.readLine();
			}
//			System.out.println(orgintxt.size());
		}catch(Exception e){
			System.out.println("orgintxt not find");
		}
		Object[] key = property.keySet().toArray();
		try{
			FileWriter fw = new FileWriter(wtxt,true);
			BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i = 0; i<key.length; i++)
		{  
			System.out.println(key[i]);
			write(key[i].toString(),bw);
			ArrayList predicate=(ArrayList) property.get(key[i]); 
//			for(int j=0;j<predicate.size();j++){
//				System.out.println(predicate.get(j));
//			}
			for(int j=0;j<orgintxt.size();j++){
				String ss=orgintxt.get(j).toString();
				String[] ns=ss.split(" ");
				String aa=ns[1];
				for(int k=0;k<predicate.size();k++){
					if(predicate.get(k).equals(aa)){
						System.out.println(ss);
						write(ss,bw);
					}
				}
//				if(predicate.indexOf(aa)==0){
//					System.out.println(ss);
//					orgintxt.remove(j);
//				}
			}	
		}}catch(Exception e){
			System.out.println("!!");
		}
	}
	public static void write(String ss,BufferedWriter bw) throws IOException{		
		bw.write(ss);
		bw.flush(); 
		bw.newLine();
	}
}
