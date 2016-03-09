package property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitsource {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetsourceName();
	}
	
	/* 按行读取并计数。key为name,value为次数*/
	public static HashMap GetsourceName(){
		ArrayList sourceName=new ArrayList();
		HashMap sourceNum=new HashMap();
		int num;
		String rmodepath="D:\\学习中\\实验室\\RDF\\Data\\entity_p1\\film.txt";
//		String rmodepath="./data\\filmTriple1952.txt";
//		String wmodepath="D:\\学习中\\实验室\\RDF\\Data\\Data\\属性模板\\film1.txt";
		try{
			FileReader fr = new FileReader(rmodepath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
				Pattern pattern = Pattern.compile("<http://(.+?)/");
				Matcher matcher = pattern.matcher(pre);
				if(matcher.find()){
//				    System.out.println(matcher.group(1));
					String str=matcher.group(1);					
					if(sourceNum.containsKey(str)==false){
						num=0;
						sourceNum.put(str, num++);
					}
					if(sourceNum.containsKey(str)==true){
						num=((int) sourceNum.get(str))+1;
						sourceNum.put(str, num);
					}
					if(sourceName.indexOf(str)==-1){
						sourceName.add(str);
					}
				}
				pre=br.readLine();
			}
		}catch(Exception e){
			System.out.println("File not find!");
		}
//		System.out.println(sourceName.size());
		System.out.println(sourceNum.size());
		for(int i=0;i<sourceName.size();i++){		
			System.out.print(sourceName.get(i).toString()+": ");
			System.out.println(sourceNum.get(sourceName.get(i)));
//			Object[] key =  sourceNum.keySet().toArray();
//			System.out.println(key[i]+" "+sourceNum.get(key[i]));
		}
		return sourceNum;		
	}	
}
