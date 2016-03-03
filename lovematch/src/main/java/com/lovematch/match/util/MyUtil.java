package com.lovematch.match.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.util.fileupload.FileUtil;

public class MyUtil {
	
//	private MyUtil(){
//		
//	}
//	
//	private static MyUtil instance = null;
//	public static MyUtil getInstance(){
//		if(instance == null){
//			instance = new MyUtil();
//		}
//		return instance;
//	}
	
//	public MyUtil(){
//		
//	}
	
	public static  String change(String src) {   
        if (src != null) {   
            StringBuffer sb = new StringBuffer(src);   
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));   
            return sb.toString();   
        } else {   
            return null;   
        }   
    }
	
	public static  Map<String,String> findPostUnnullInput(Object obj) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		Field[] f = obj.getClass().getDeclaredFields();
		
		for (Field field : f) {
			String fdName = field.getName();
			Method m = obj.getClass().getMethod("get"+change(fdName), null);
			String o = (String) m.invoke(obj, null);
			if(!o.trim().equals("") && o != null){
				map.put(fdName, o);
			}
		}
		return map;
	}
	
	
	public static String replaceSpace(String s){
		String reg = "\\s+";
		if(s.trim().equals("") || s == null){
			s = "%";
			//System.out.println("the s is null or  '' "+s);
			return s.trim();
		}else{
			//System.out.println("the s is replace "+s.replaceAll(reg, "%"));
			return s.replaceAll(reg, "%");
			
		}
		
	}
	
	public static int getPageNumberCount(int pageNum, int listCount ,int pageSize){
		int maxPage = listCount % pageSize == 0? listCount/pageSize-1 : listCount/pageSize ;
		//int res1 = listCount/pageSize;
		//int res2 = listCount/pageSize-1;
		//System.out.println("======="+maxPage+"========="+res1+"-------"+res2+"---"+listCount);
		if(pageNum <=0){
			return 0;
		}else if(pageNum >= maxPage){
			return maxPage;
		}
		return pageNum;
	}
	
	public static String replaceTheSpace(String s){
		String reg = "\\s+";
		return s.trim().replaceAll(reg, "%");
	}
	
	public static void copyValidBeanToDestBean(Object orgin, Object dest){
		Field[] orginFields = orgin.getClass().getDeclaredFields();
		try {
			Field[] destFields = dest.getClass().getDeclaredFields();	
			for (Field orgField : orginFields) {
				for (Field destField : destFields) {
					if(destField.getName().equals(orgField.getName())){
						//System.out.println("---->destfieldname="+destField.getName()+"----- orginfieldname="+orgField.getName());
						Method destSetMethod = dest.getClass().getMethod("set"+changeFieldNameFirstUpper(destField.getName()), destField.getType());
						Method orginGetMethod = orgin.getClass().getMethod("get"+changeFieldNameFirstUpper(destField.getName()));
						destSetMethod.invoke(dest, orginGetMethod.invoke(orgin));
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static  String changeFieldNameFirstUpper(String src) {   
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);   
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));   
            return sb.toString();   
        } else {   
            return null;   
        }   
    }
	
	public static Map<String,String> WebInfoStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("about", "本院介绍");
		statusMap.put("hr", "人才招聘");
		statusMap.put("honor", "荣誉资质");
		statusMap.put("manageteam", "管理团队");
		statusMap.put("organ", "组织机构");
		statusMap.put("contact", "联系我们");
		statusMap.put("service", "产业服务");
		statusMap.put("coop", "合作交流");
		return statusMap;
	}
	
	public static Map<String,String> WebNewsStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("zhxw", "综合新闻");
		statusMap.put("hyzx", "行业资讯");
		statusMap.put("yjdt", "科研动态");
		statusMap.put("advice", "通知公告");
		return statusMap;
	}
	
	public static Map<String,String> WebTeamStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("zjtd", "专家团队");
		statusMap.put("jstd", "技术团队");
		statusMap.put("gwtd", "顾问团队");
		return statusMap;
	}
	
	public static Map<String,String> WebAreaStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("cgzr", "成果转让");
		statusMap.put("jszy", "技术转移");
		statusMap.put("zlsq", "专利授权");
		statusMap.put("zlzx", "专利咨询");
		return statusMap;
	}
	public static Map<String,String> WebContStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("gjxm", "国家项目");
		statusMap.put("sjxm", "省级项目");
		statusMap.put("shijxm", "市级项目");
		statusMap.put("wtxm", "委托项目");
		return statusMap;
	}
	/**
	 * 产业服务 type
	 * @return
	 */
	public static Map<String,String> WebCYFWStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("gdzx", "高端咨询");
		statusMap.put("xyhz", "学研合作");
		statusMap.put("fhqy", "孵化企业");
		statusMap.put("jcjy", "检测检验");

		return statusMap;
	}
	
	public static Map<String,String> WebBizStatusMap(){
		Map<String,String> statusMap = new HashMap<String, String>();
		statusMap.put("team", "科研团队");
		statusMap.put("searchArea", "研究领域");
		statusMap.put("service", "产业服务");
		statusMap.put("news", "新闻中心");
		statusMap.put("biz", "学术活动");
		statusMap.put("cont", "科研成果");
		statusMap.put("advice", "通知");
		return statusMap;
	}
	
	public static String operatThePreviewPhoto(MultipartFile file, String type,
			HttpSession session, Long type_id) throws Exception {
		String fileName = file.getOriginalFilename();
		String fileExtension = fileName
				.substring(fileName.lastIndexOf(".") + 1);
		String path = session.getServletContext().getRealPath("/")
				+ "/resources/attached/" + type + "/" + type_id;
		FileUtil.createRealPath(path, session);
		String previewFile = path + File.separator + "small" + "."
				+ fileExtension;
		File saveDest = new File(path + File.separator + fileName);
		file.transferTo(saveDest);
		
		FileUtil.getPreviewImage(saveDest, new File(previewFile),fileExtension, GlobalDefs.PHOTO_WIDTH,
					GlobalDefs.PHOTO_HEIGHT);
		
		String savePath = "/resources/attached/" + type + "/" + type_id
				+ "/small" + "." + fileExtension;
		return savePath;
	}
	
	public static String operatThePreviewLargePhoto(MultipartFile file, String type,
			HttpSession session, Long type_id) throws Exception {
		String fileName = file.getOriginalFilename();
		String fileExtension = fileName
				.substring(fileName.lastIndexOf(".") + 1);
		String path = session.getServletContext().getRealPath("/")
				+ "/resources/attached/" + type + "/" + type_id;
		FileUtil.createRealPath(path, session);
		String previewFile = path + File.separator + "large" + "."
				+ fileExtension;
		File saveDest = new File(path + File.separator + fileName);
		file.transferTo(saveDest);
		
		FileUtil.getPreviewImage(saveDest, new File(previewFile),fileExtension, GlobalDefs.PHOTO_WIDTH,
					GlobalDefs.PHOTO_HEIGHT);
		
		String savePath = "/resources/attached/" + type + "/" + type_id
				+ "/large" + "." + fileExtension;
		return savePath;
	}
	
	/*
	public static String operatThePreviewPhoto(MultipartFile file, String type, HttpSession session, Long type_id) throws Exception{
		String fileName = file.getOriginalFilename();
		String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
		String path = session.getServletContext().getRealPath("/")+"/resources/attached/"+type+"/"+type_id;
		FileUtil.createRealPath(path, session);
		String previewFile = path+File.separator+"small"+"."+fileExtension;
		File saveDest = new File(path + File.separator + fileName);
		file.transferTo(saveDest);
		
		FileUtil.getPreviewImage(saveDest, new File(previewFile), fileExtension,GlobalDefs.PHOTO_WIDTH,GlobalDefs.PHOTO_HEIGHT);
		String savePath ="/resources/attached/"+type+"/"+type_id+"/small"+"."+fileExtension;
		return savePath;
	}*/
	
}
