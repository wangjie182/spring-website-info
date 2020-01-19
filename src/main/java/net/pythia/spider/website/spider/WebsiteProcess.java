package net.pythia.spider.website.spider;

import net.pythia.spider.website.entity.Website;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class WebsiteProcess implements PageProcessor {

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().css("div.detlist.gbox div.e").nodes();
        if (nodes.size() == 0) {
            this.saveWebsite(page);}else {
        //如果不为空，表示这是列表页，解析出详情页的url地址，放到任务队列中
        for(Selectable node:nodes){
            String jobInfoUrl = node.links().toString();
//            System.out.println(jobInfoUrl);
            //把获取到的详情页的url地址放到任务队列中
            page.addTargetRequest(jobInfoUrl);
        }
        //获取下一  页按钮的url
        //div的class是p_in  下面的li的class是bk
        String bkUrl=page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();//get(1)拿到第二个
//        System.out.println(bkUrl);

        //把下一页的url放到任务队列中
        page.addTargetRequest(bkUrl);
    }
}

    private void saveWebsite(Page page) {
        Html html = page.getHtml();
        List<Website> list = new ArrayList<>();
	  
//	    System.out.println(str);
       
        //创建招聘详情对象
    	Website website=new Website();
        //获取数据，封装到对象中
        //两种获取的方法，一种是直接html.css，另一种是使用Jsoup.parse解析html字符串
    	
      	
      	String addr = page.getHtml().regex("<p class=\"fp\">.*?</span>([^<]+)</p>").toString();
        page.putField("addr", addr);

       String addrjobStr = Jsoup.parse(html.css("div.in div.cn p.msg.ltype","title").toString()).text();
       String JobAddr=addrjobStr.substring(0,addrjobStr.indexOf("|"));
       page.putField("JobAddr", JobAddr);

       String CompanyName=  Jsoup.parse(html.css("div.cn p.cname a","title").toString()).text();
       page.putField("CompanyName", CompanyName);

       List<Selectable> nodes = html.css("div.bmsg.job_msg.inbox p").nodes();
       String jobInfo = null;
       for(Selectable node:nodes){
       	String jobInfo1 = Jsoup.parse(node.toString()).text() ;	
       	jobInfo = jobInfo1 +jobInfo;}
       page.putField("jobInfo", jobInfo);

       String companyInfo = html.css("div.tmsg","text").toString();
       page.putField("companyInfo", companyInfo);

       String JobName = Jsoup.parse(html.css("div.cn h1","title").toString()).text();
       page.putField("JobName", JobName);
       
       String Salary = Jsoup.parse(html.css("div.cn strong").toString()).text();
       page.putField("Salary", Salary);
       
       website.setCompanyName(CompanyName);
       website.setCompanyAddr(addr);
       website.setJobAddr(JobAddr);
       website.setjobInfo(jobInfo);
        website.setcompanyInfo(companyInfo);
        website.setJobName(JobName);
        website.setSalary(Salary);
        
        list.add(website);
        page.putField("list", list);
}

    private Site site = Site.me().setCharset("gbk").setTimeOut(10*1000).setRetrySleepTime(10*1000).setRetryTimes(3);
    @Override
    public Site getSite() {
        return this.site;
    }

    @Autowired
    private WebsitePipeline websitePipeline;

    @Scheduled(initialDelay = 200 ,fixedDelay = 1000*100000)
    public void process(){
        Spider.create(new WebsiteProcess())
//        .addUrl("https://search.51job.com/list/170200,000000,0000,00,9,99,+,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=")        
//        .addUrl("https://jobs.51job.com/wt01_ed04/dashujukaifa/")
        .addUrl("https://jobs.51job.com/changsha/wt01_ed04/dashujukaifa/")
        .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(10)
                .addPipeline(websitePipeline)
//                .addPipeline(new WebsitePipeline("D:\\eclipse-workspace\\spider_website_info-master3\\data\\webmagic") {
//				} )
//				("D:\\eclipse-workspace\\spider_website_info-master3"))
                .run();
    }
}
