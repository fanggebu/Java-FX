package application.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
 
 /**
  * 别人所写的读取文件
  * @author qiuhen
  *
  */
public class ReadLoadTxtFileRunnable {
 
 
	private String filePath;
	
	public ReadLoadTxtFileRunnable(String filePath) {
		this.filePath = filePath;
	}
 
	public String run() {
		return this.read(filePath);
	}

 
	/**
	 * @Title: read
	 * @Description: 读取txt文件内容
	 * @param filePath
	 *            文件绝对路径
	 * @return List
	 * @author 
	 * @date 2015年12月26日
	 */
	public String read(String filePath) {
 
		filePath = null == filePath ? null : filePath.trim();
 
		if (null == filePath || "".equals(filePath)) {
			
			
		}
 
		InputStream is = null;
		Reader reader = null;
		BufferedReader bufRead = null;
		
		String text="";
		
		try {
			is = new FileInputStream(filePath);
 
			// 判断文件的编码格式
			String charset = TxtCommonMethods.getFileCharset(filePath);
 
			reader = new InputStreamReader(is, charset);
 
			bufRead = new BufferedReader(reader);
 
			String line = null;
 
			String[] arrs = null;
 
			while ((line = bufRead.readLine()) != null) {
				text=text+line+"\n";
				
			}
//			System.out.println(text);
 
		} catch (FileNotFoundException e) {
			System.out.println("Read file '" + filePath + "' fail:" + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("Read file '" + filePath + "' fail:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Read file '" + filePath + "' fail:" + e.getMessage() );
		} catch (Exception e) {
			System.out.println("Read file '" + filePath + "' fail:" + e.getMessage());
		} finally {
			TxtIOUtils.closeReader(bufRead);
			TxtIOUtils.closeReader(reader);
			TxtIOUtils.closeStream(is, null);
			
		}
		return text;
	}
}