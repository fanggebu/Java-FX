package application.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
public class TxtCommonMethods {
 
	/**
	 * @Title: getFileCharset
	 * @Description: 判断文件的编码格式
	 * @param filePath
	 *            文件绝对路径
	 * @return String
	 * @author 
	 * @date 2015年12月26日
	 */
	public static String getFileCharset(String filePath) {
 
		File file = new File(filePath);
 
		if (!file.exists()) {
			System.out.println("File not found.");
		}
		// 默认编码格式为GBK
		String charset = "GBK";
 
		FileInputStream is = null;
		BufferedInputStream bis = null;
 
		try {
			byte[] first3Bytes = new byte[3];
 
			boolean checked = false;
 
			is = new FileInputStream(file);
 
			bis = new BufferedInputStream(is);
 
			bis.mark(0);
 
			int read = bis.read(first3Bytes, 0, 3);
 
			if (-1 == read) {
				charset = "GBK";
			} else if (first3Bytes[0] == (byte) 0xFF
					&& first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();
 
			if (!checked) {
 
				int loc = 0;
 
				while ((read = bis.read()) != -1) {
 
					loc++;
 
					if (read >= 0xF0) {
						break;
					}
 
					if (0x80 <= read && read <= 0xBF) {
						// 单独出现BF以下的,也算GBK
						break;
					}
 
					if (0x80 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							// GBK
							continue;
						} else {
							break;
						}
					} else if (0xE0 <= read && read <= 0xEF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}
			}
 
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		} finally {
			TxtIOUtils.closeStream(bis, null);
			TxtIOUtils.closeStream(is, null);
		}
 
		return charset;
	}
}
