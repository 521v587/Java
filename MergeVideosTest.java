package cn.dean.merge;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class MergeVideosTest {
	
	/**
	 * 测试MergeVideosUtils工具类
	 */
	@Test
	public void testMergeVideos() throws IOException{
		MergeVideosUtils.MergeVideos(new File("E:\\videocache\\.三个代表重要思想.m3u8.d"),   
	             new File("E:\\video"), "video", 209); 
	}
}
