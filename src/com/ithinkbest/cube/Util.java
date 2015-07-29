package com.ithinkbest.cube;

import java.util.HashMap;
import java.util.Map;

public class Util {
	Map<String, String> mapXyz2Chinese;
	//http://w.astro.berkeley.edu/~converse/rubiks.php?id1=basics&id2=notation
	String[][] dataXyz2Chinese={
			{"X11","右上"},
			{"X12","右翻"},
			{"X13","右下"},
			{"X21","中上"},
			{"X22","X翻"},
			{"X23","中下"},
			{"X31","左上"},
			{"X32","左翻"},
			{"X33","左下"},
			
			{"Y11","前順"},
			{"Y12","前翻"},
			{"Y13","前逆"},
			{"Y21","中順"},
			{"Y22","Y翻"},
			{"Y23","中逆"},
			{"Y31","後順"},
			{"Y32","後翻"},
			{"Y33","後逆"},
			
			{"Z11","上左"},
			{"Z12","上翻"},
			{"Z13","上右"},
			{"Z21","中左"},
			{"Z22","Z翻"},
			{"Z23","中右"},
			{"Z31","下左"},
			{"Z32","下翻"},
			{"Z33","下右"}
			
			
			
			
			
	};
	
	public Util() {
		mapXyz2Chinese=new HashMap<>();
		for (int i=0;i<dataXyz2Chinese.length;i++){
			
				mapXyz2Chinese.put(dataXyz2Chinese[i][0],dataXyz2Chinese[i][1]);
			
		}
//		System.out.println(mapXyz2Chinese);
//		mapXyz2Chinese.put(key, value)
	}


	public String getTranslatedCmd(String source, int Style) {
		// String sol001ch="[中右,右下][中右,右下][中右,右翻][中左,右下][中左,右下][中左,右翻]";
		// String sol001 = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		StringBuilder sb = new StringBuilder();
		
		String[] items=source.split(" ");
		for (String item:items){
			sb.append(mapXyz2Chinese.get(item)).append(" ");
		}
		
		return sb.toString();
	}
	
	public String getBackwards(String source) {
		
		StringBuilder sb = new StringBuilder();
		//sb.append("XXX"+source+"XXX");
		
		String[] items=source.split(" ");

		
		for (int i=items.length-1;i>=0;i--){
//			System.out.println(i+" "+items[i]);
			sb.append(items[i]).append(" ");
//			
		}
		
		
		
//		for (int i=(items.length-1);i==0;i--){
//			System.out.println(i+" "+items[i]);
//			sb.append(items[i]).append(" ");
//		}
			
		return sb.toString();
	}
}
