package application.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.Channel;

public class TxtIOUtils {
	 
 
	public static void closeStream(InputStream is, OutputStream out) {
 
		if (null != out) {
			try {
				out.close();
			} catch (IOException e) {
				
			}
			out = null;
		}
 
		if (null != is) {
			try {
				is.close();
			} catch (IOException e) {
			}
			is = null;
		}
	}
 
	public static void closeReader(Reader reader) {
 
		if (null != reader) {
			try {
				reader.close();
			} catch (IOException e) {
			}
			reader = null;
		}
	}
 
	public static void closeWriter(Writer writer) {
 
		if (null != writer) {
			try {
				writer.close();
			} catch (IOException e) {
			}
			writer = null;
		}
	}
 
	public static void closeChannel(Channel c) {
 
		if (null != c) {
			try {
				c.close();
			} catch (IOException e) {
			}
			c = null;
		}
	}
}
