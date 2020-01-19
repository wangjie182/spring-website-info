package net.pythia.spider.website.entity;

import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long websiteId;
//    private String websiteName;
//    private String websiteUrl;
//    private String websiteType;
//    private Date createdTime;
//    private Integer websiteWeight; //权重
//    private String operator;        //操作人
//    private Integer classfication;

    private String companyName;
    private String companyAddr;
    private String jobInfo;
    private String jobName;
    private String jobAddr;
    private String companyInfo;
    private String salary;
//    private String url;
	public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public  String getCompanyName() {
     return companyName;
    }
    

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
    public  String getcompanyAddr() {
        return companyAddr;
       }

    public void setjobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }
    public  String getjobInfo() {
        return jobInfo;
       }
    
    public void setcompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }
    public  String getcompanyInfo() {
        return companyInfo;
       }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public  String getjobName() {
        return jobName;
       }


//    public void setUrl(String url) {
//        // TODO Auto-generated method stub
//        this.url = url;
//    }
//    public  String geturl() {
//        return url;
//       }
    public void setSalary(String salary) {
        // TODO Auto-generated method stub
        this.salary = salary;
    }
    public  String getsalary() {
        return salary;
       }
	public void setJobAddr(String JobAddr	) {
		// TODO Auto-generated method stub
		 this.jobAddr = JobAddr;
	}
	 public  String getJobAddr() {
	        return jobAddr;
	       }
//    public Date getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }

    public Long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Long websiteId) {
        this.websiteId = websiteId;
    }

//    public String getWebsiteName() {
//        return websiteName;
//    }
//
//    public void setWebsiteName(String websiteName) {
//        this.websiteName = websiteName;
//    }
//
//    public String getWebsiteUrl() {
//        return websiteUrl;
//    }
//
//    public void setWebsiteUrl(String websiteUrl) {
//        this.websiteUrl = websiteUrl;
//    }
//
//    public String getWebsiteType() {
//        return websiteType;
//    }
//
//    public void setWebsiteType(String websiteType) {
//        this.websiteType = websiteType;
//    }
//
//    public Integer getWebsiteWeight() {
//        return websiteWeight;
//    }
//
//    public void setWebsiteWeight(Integer websiteWeight) {
//        this.websiteWeight = websiteWeight;
//    }
//
//    public String getOperator() {
//        return operator;
//    }
//
//    public void setOperator(String operator) {
//        this.operator = operator;
//    }
//
//    public Integer getClassfication() {
//        return classfication;
//    }
//
//    public void setClassfication(Integer classfication) {
//        this.classfication = classfication;
//    }
}
