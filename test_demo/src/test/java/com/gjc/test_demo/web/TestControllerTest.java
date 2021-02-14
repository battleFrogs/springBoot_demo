package com.gjc.test_demo.web;

import com.alibaba.fastjson.JSONObject;
import com.gjc.common.constant.ResultData;
import com.gjc.test_demo.param.PostTestParam;
import com.gjc.test_demo.service.TestService;
import com.gjc.test_demo.vo.PostTestVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
class TestControllerTest {

    @InjectMocks
    private TestController testController;

    @Mock
    private TestService testService;

    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(testController).build();  // 初始化操作

        // 对testService 进行mock数据处理
        Mockito.when(testService.test(Mockito.anyLong())).thenReturn("是我");

    }

    @Test
    public void getTest() throws Exception {
        // 构造请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/getTest")
                .param("name", "gjc");

        // 发送请求
        mockMvc.perform(builder)
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void postTest() throws Exception {


        // 构造请求体
        PostTestParam param = new PostTestParam();
        param.setAge(20);
        param.setName("gjc");

        // 构造请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("/postTest").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JSONObject.toJSONString(param));

        // 发送请求
        MvcResult mvcResult = mockMvc.perform(builder)
                .andReturn();

        // 获取请求结果
        int status = mvcResult.getResponse().getStatus();
        String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ResultData resultData = JSONObject.parseObject(contentAsString, ResultData.class);
        Map<String, Object> data = resultData.getData();
        PostTestVo result = JSONObject.parseObject(JSONObject.toJSONString(data), PostTestVo.class);

        // 校验结果参数的正确性
        Assertions.assertEquals(status, 200);
        Assertions.assertEquals(resultData.getCode(), ResultData.ResultEnum.SUCCESS.getCode());

        Assertions.assertEquals(result.getAddName(),"gjc加上");
        Assertions.assertEquals(result.getAddAge(),21);

    }

    @Test
    public void postDetailTest() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/postDetailTest")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("id", "1");

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}