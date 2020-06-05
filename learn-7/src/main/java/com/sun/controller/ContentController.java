package com.sun.controller;

import com.sun.pojo.Content;
import com.sun.serivce.ContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;
    Logger logger = Logger.getLogger(ContentController.class);

    @ResponseBody
    @RequestMapping(value = "/a/u/content",method = RequestMethod.POST)
    public Map<String,Object> addContent(Content content){
        logger.info("add content param is : " + content);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            content.setCreateAt(time);
            content.setUpdateAt(time);
            content.setCreateBy(time);
            content.setUpdateBy(time);
            contentService.insert(content);
            resultMap.put("code",0);
            resultMap.put("message","success");
            resultMap.put("data",content.getId());
        } catch (Exception e){
            resultMap.put("code",-1);
            resultMap.put("message","error");
            e.printStackTrace();
            logger.error("add content error  param is : "+content);
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/content/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updateContent(@PathVariable Long id,
                                            Content content){
        logger.info("add content param is : " + content+" id is : "+id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            //1.查询以前的数据，判断有没有。
            Content updateContent = contentService.selectByPrimaryKey(id);
            logger.info("updateContent is : "+updateContent);
            if(null != updateContent){
                resultMap.put("code",-100);
                resultMap.put("message","修改内容不存在");
            }
            //2.更新内容
            updateContent.setImg(content.getImg());
            updateContent.setType(content.getType());
            updateContent.setUrl(content.getUrl());
            updateContent.setContent(content.getContent());
            updateContent.setUpdateAt(time);
            updateContent.setUpdateBy(time);
            contentService.updateByPrimaryKey(updateContent);
            resultMap.put("code",0);
            resultMap.put("message","success");
            resultMap.put("data",content.getId());
        } catch (Exception e){
            resultMap.put("code",-1);
            resultMap.put("message","error");
            e.printStackTrace();
            logger.error("update content error  param is : "+content +" id "+id);
        }
        return resultMap;
    }
    @ResponseBody
    @RequestMapping(value = "/a/u/content/{id}",method = RequestMethod.GET)
    public Map<String,Object> getContent(@PathVariable Long id){
        logger.info("get content param is : " + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Content content = contentService.selectByPrimaryKey(id);
            logger.info("content is : "+content);
            resultMap.put("code",0);
            resultMap.put("message","success");
            resultMap.put("data",content);
        } catch (Exception e){
            resultMap.put("code",-1);
            resultMap.put("message","error");
            e.printStackTrace();
            logger.error("get content error  param is : "+id);
        }
        return resultMap;
    }
























}
