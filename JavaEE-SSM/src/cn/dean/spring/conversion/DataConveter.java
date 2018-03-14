package cn.dean.spring.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * S:代表页面传过来的内容
 * T：代表即将转换的类型
 * @author 丁楠
 *
 */
public class DataConveter implements Converter<String, Date> {
	

	@Override
	public Date convert(String source) {
		try{
			if(source != null){
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm/ss");
				Date date = df.parse(source);
				return date;
			}
		}catch(Exception ex){
			
		}
		return null;
	}
}
