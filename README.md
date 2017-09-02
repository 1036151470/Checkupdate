## 应用名称
Checkupdate（网站视频节目更新提醒）

## 技术栈	
	JDk8
	Spring
	Spring boot
	Bootstrap3
	Freemarker
	Jsoup
	Mybatis
	
## 功能介绍
抓取指定网站的指定视频节目，并存入抓取的数据到数据库，使用调度框架对存入数据库的数据重新定时进行对比，相同就跳过比较下一个，不同就前端实时响应写入当前response


## 快速开始
* 本程序为maven项目，所有首先需要下载和配置好maven。http://maven.apache.org/download.cgi
* 返回本程序项目主页点击右上角按钮进行下载
* 解压项目
* 使用命令 mvn clean package构建项目
* 构建完成后一般在target\目录下会得到一个jar包，运行该jar包即可

## 应用截图
![图1](screenshot/001.jpg)
