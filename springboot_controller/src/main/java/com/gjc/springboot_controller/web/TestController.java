package com.gjc.springboot_controller.web;

import com.gjc.common.constant.ResultData;
import com.gjc.springboot_controller.param.GetJson;
import com.gjc.springboot_controller.param.JsonListData;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class TestController {


    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * get请求
     * 请求方式 Get请求  localhost:8080/get?name=gjc
     *
     * @return resultData
     */
    @GetMapping("/get")
    public ResultData get(@RequestParam String name) {
        log.info("name: {}", name);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * Post请求
     * <p>
     * 请求方式 ：post请求 localhost:8080/post?name=gjc&age=28
     * 或者  localhost:8080/post contentType:x-www-form-urlencoded , [name:gjc age:28]
     * 或者  localhost:8080/post contentType:form-data , [name:gjc age:28]
     *
     * @param name 名称
     * @param age  年龄
     * @return resultData
     */
    @PostMapping("/post")
    public ResultData post(String name, Integer age) {
        log.info("name:{} , age: {}", name, age);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");

    }


    /**
     * json格式的请求体请求
     * <p>
     * get请求 ： localhost:8080/getJson
     * <p>
     * * 请求体都为
     * {
     * "name": "gjc",
     * "age": 12,
     * "price": 213.65,
     * "total": 56.32,
     * "date": 1614398981000
     * }
     * ****************************************************
     * post请求： localhost:8080/getJson
     * <p>
     * <p>
     * 请求体都为
     * {
     * "name": "gjc",
     * "age": 12,
     * "price": 213.65,
     * "total": 56.32,
     * "date": 1614398981000
     * }
     *
     * @param getJson 请求json
     * @return resultData
     */
    @RequestMapping("/getJson")
    public ResultData getJson(@RequestBody GetJson getJson) {
        log.info("name : {} ,age: {}, price: {} ,total:{}, date: {}"
                , getJson.getName(), getJson.getAge(), getJson.getPrice(), getJson.getTotal(), getJson.getDate());
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * post请求 ，localhost:8080/jsonListData
     * 请求体参数：
     * {
     * "list": [
     * {
     * "name": "gjc",
     * "age": 25,
     * "price": 34.22,
     * "total": 12.43,
     * "date": 1614398981000
     * },
     * {
     * "name": "jc",
     * "age": 11,
     * "price": 34.32,
     * "total": 12.43,
     * "date": 1614397681000
     * }
     * ]
     * }
     *
     * @param jsonListData 参数
     * @return resultDate
     */
    @PostMapping("/jsonListData")
    public ResultData jsonListData(@RequestBody JsonListData jsonListData) {

        for (JsonListData.JsonListDataBean jsonListDataBean : jsonListData.getList()) {
            log.info("name : {} ,age: {}, price: {} ,total:{}, date: {}"
                    , jsonListDataBean.getName(), jsonListDataBean.getAge(), jsonListDataBean.getPrice(),
                    jsonListDataBean.getTotal(), jsonListDataBean.getDate());
        }
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * post请求 ： localhost:8080/postMap
     * <p>
     * 请求参数：
     * name:gjc
     * age:12
     * price:213.65
     * total:56.32
     * date:1614398981000
     *
     * @param map 参数
     * @return resultData
     */
    @PostMapping("/postMap")
    public ResultData getPostMap(@RequestParam Map<String, Object> map) {
        log.info("name : {} ,age: {}, price: {} ,total:{}, date: {}",
                MapUtils.getString(map, "name"), MapUtils.getInteger(map, "age"),
                MapUtils.getDouble(map, "price"), BigDecimal.valueOf(MapUtils.getDouble(map, "total")),
                new Date(MapUtils.getInteger(map, "date")));
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");

    }

    /**
     * get 请求 localhost:8080/getIds?ids=1,2,3,4,5
     *
     * @param ids 参数
     * @return resultData
     */
    @GetMapping("/getIds")
    public ResultData getIds(@RequestParam("ids") List<Integer> ids) {
        log.info("ids： {}", ids);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * get请求 ，localhost:8080/getArrayIds?ids=1,2,3,4,5
     *
     * @param ids 参数数组
     * @return resultData
     */
    @GetMapping("/getArrayIds")
    public ResultData getArrayIds(String[] ids) {
        log.info("ids {}", Arrays.asList(ids));
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * 单个文件
     * post请求 form-data localhost:8080/fileUpload
     *
     * @param file 文件
     * @return resultData
     */
    @RequestMapping("/fileUpload")
    public ResultData fileUpload(MultipartFile file) {
        String name = file.getName();
        long size = file.getSize();
        String contentType = file.getContentType();
        log.info("name : {} , size : {} ,contentType: {}", name, size, contentType);


        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 获取输入流
            inputStream = file.getInputStream();
            File directory = new File("D:\\programWorkspace\\IdeaWorkspace\\" +
                    "springBoot_demo\\springboot_controller\\src\\main\\java\\com\\gjc\\springboot_controller\\text.txt");
            fileOutputStream = new FileOutputStream(directory);
            int data;
            // 读取输入流，复制参数，一直读取到结束
            while ((data = inputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 最后流的关闭
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * post 请求 form-data localhost:8080/fileUploadMany
     * 请求参数 files： 多个文件
     *
     * @param files 参数
     * @return resultData
     */
    @RequestMapping("/fileUploadMany")
    public ResultData fileUploadMany(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            FileOutputStream fileOutputStream = null;
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();


                File resultFile;
                if (file.getOriginalFilename().split("\\.")[1].equals("png")) {
                    resultFile = new File("D:\\programWorkspace\\IdeaWorkspace\\" +
                            "springBoot_demo\\springboot_controller\\src\\main\\java\\com\\gjc\\springboot_controller\\text.png");
                } else {
                    resultFile = new File("D:\\programWorkspace\\IdeaWorkspace\\" +
                            "springBoot_demo\\springboot_controller\\src\\main\\java\\com\\gjc\\springboot_controller\\text.txt");
                }
                fileOutputStream = new FileOutputStream(resultFile);

                int data;
                while ((data = inputStream.read()) != -1) {
                    fileOutputStream.write(data);

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

}
