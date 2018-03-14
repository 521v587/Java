package cn.dean.merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 合并视频文件
 * @author 丁楠
 *
 */
public class MergeVideosUtils {
	/**
	 * source为源地址，destination为合并之后的文件地址，videoName为合并后视频的名称，num为视频数量
	 * @param source
	 * @param destination
	 * @param videoName
	 * @param num
	 * @throws IOException
	 */
	public static void MergeVideos(File source, File destination, String videoName, int num) throws IOException{
		FileOutputStream out = new FileOutputStream(destination + "\\" + videoName);
		FileInputStream in = null;
		for(int i = 1 ; i <= num; i++){
			String videoPath = source + "\\" + i;
			File file = new File(videoPath);
			in = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = in.read(bytes)) > 0){
				out.write(bytes,0,len);
			}
		}
		in.close();
		out.close();
	}
}
