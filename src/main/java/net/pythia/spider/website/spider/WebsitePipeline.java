package net.pythia.spider.website.spider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.pythia.spider.website.entity.Website;
import net.pythia.spider.website.service.WebsiteService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import net.pythia.spider.website.service.impl.*;


//@Component
//public abstract class WebsitePipeline implements Pipeline {
//	private Logger logger;
//	private String filename="";
//	private DateFormat bf=null;
//	private Date date=null;
//	protected String path;
//	public static String PATH_SEPERATOR = "\\";
//
//	public void setPath(String path) {
//		if (!path.endsWith(PATH_SEPERATOR))
//			path = (new StringBuilder()).append(path).append(PATH_SEPERATOR)
//					.toString();
//		this.path = path;
//	}
//
//	/**
//	 * 空参构造--使用默认路径
//	 * @return 
//	 */
//	
//	public WebsitePipeline(){
//		logger = LoggerFactory.getLogger(getClass());
//		setPath("D:\\eclipse-workspace\\spider_website_info-master3\\data\\webmagic");
//	}
//	/**
//	 * 参数构造--指定路径
//	 * @param path
//	 * @return 
//	 */
//	public WebsitePipeline(String path) {
//		logger = LoggerFactory.getLogger(getClass());
//		setPath(path);
//	}
//	public String filenameByDate() {
//		bf = new SimpleDateFormat("yyyy-MM-dd");
//		date=new Date();
//		filename=bf.format(date).replaceAll("-", "");
//		return filename;
//	}
//	public void checkAndMakeParentDirecotry(String fullName) {
//		int index = fullName.lastIndexOf(PATH_SEPERATOR);
//		if (index > 0) {
//			String path = fullName.substring(0, index);
//			File file = new File(path);
//			if (!file.exists())
//				file.mkdirs();
//		}
//	}
//
//	public File getFile(String fullName) {
//		checkAndMakeParentDirecotry(fullName);
//		return new File(fullName);
//	}
//	@Override
//	public void process(ResultItems resultItems, Task task) {
//		
//		try{
//			String filepath=new StringBuilder().append(this.path).
//					append(PATH_SEPERATOR).
//					append(filenameByDate()).append(".txt").toString();
//			System.out.print(filepath);
//			//true---不将原先文件内容覆盖
//			PrintWriter printWriter = new PrintWriter(new FileWriter(getFile(filepath),true));
////			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter
////            		(new FileOutputStream(getFile(path + resultItems.get("title") + ".txt")),"UTF-8"));
//
////			printWriter.write(JSON.toJSONString(resultItems.getAll()));
//			
//            for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
//                printWriter.println(entry.getKey() + ":\t" + entry.getValue());  
//            }
//			
////            WebsiteServiceImpl service = new WebsiteServiceImpl();
////    		List<Website> list = resultItems.get("list");
////          if(list!=null){
////              //保存数据到数据库中
////              service.saveAll(list);
////          }
//			printWriter.close();
//		} catch (IOException e) {
//			logger.warn("write file error", e);
//			System.out.println("文件写入出异常！！！！");
//		}
//	}
// 
//}
@Component
public class WebsitePipeline implements Pipeline {
    @Autowired
    private WebsiteService websiteService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<Website> list = resultItems.get("list");
        if (list != null){
            websiteService.saveAll(list);
        }
    }
}