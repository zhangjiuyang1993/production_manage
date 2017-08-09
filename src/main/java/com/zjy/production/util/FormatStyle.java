package com.zjy.production.util;

public class FormatStyle {

	public static void main(String[] args) {
		
	}
	
	public String fileSize(String s1){
		int iPos = 0;
		String s = "";
		StringBuffer sBuf = new StringBuffer();
		try {
			if(s1.trim().compareTo("") == 0){
				return "";
			}
			long g = Long.parseLong("1099511627776");//数字太大，Java直接写会无法识别，会引起下面比较失败
			double i = Double.parseDouble(s1);
			
			if(i <= 0){
				sBuf.append("");
			}else if(i < 1024){
				sBuf.append(i).append(" B");
				iPos = sBuf.lastIndexOf(".00 B");
				if(iPos > 0){
					sBuf.delete(iPos, sBuf.length() - 1);
				}
			}else if(i < 1024 * 1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i / 1024)).append(" KB");
				iPos = sBuf.lastIndexOf(".00 KB");
				if(iPos > 0){
					sBuf.delete(iPos, sBuf.length() - 2);
				}
			}else if(i < 1024 * 1024 * 1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i/(1024*1024))).append(" M");	//四舍五入
				iPos = sBuf.lastIndexOf(".00 M");
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}else{
				sBuf.append(new java.text.DecimalFormat(".00").format(i / (1024 * 1024 * 1024))).append(" GB");
				iPos = sBuf.lastIndexOf(".00 G");
				if(iPos > 0){
					sBuf.delete(iPos, sBuf.length() - 2);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
		return sBuf.toString();
	}
}
