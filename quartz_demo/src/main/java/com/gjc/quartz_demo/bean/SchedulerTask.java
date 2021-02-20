package com.gjc.quartz_demo.bean;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    // 方式一---------------------------------------------------------


    /**
     * 第一位, 表示秒, 取值是0 ~ 59
     * 第二位, 表示分. 取值是0 ~ 59
     * 第三位, 表示小时, 取值是0 ~ 23
     * 第四位, 表示天/日, 取值是0 ~ 31
     * 第五位, 表示月份, 取值是1 ~ 12
     * 第六位, 表示星期, 取值是1 ~ 7, 星期一，星期二...， 还有 1 表示星期日
     * 第七位, 年份, 可以留空, 取值是1970 ~ 2099
     * cron中,还有一些特殊的符号,含义如下:
     * <p>
     * (*) 星号，可以理解为每的意思，每秒、每分、每天、每月、每年...。
     * (?)问号，问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天 3 点执行，因此第六位星期的位置，是不需要关注的，就是不确定的值；同时，日期和星期是两个相互排斥的元素，通过问号来表明不指定值，比如 1 月 10 日是星期一，如果在星期的位置另指定星期二，就前后冲突矛盾了。
     * （-）减号，表达一个范围，如在小时字段中使用“10 - 12”，则表示从 10 到 12 点，即 10、11、12。
     * （,）逗号，表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一、星期二、星期四。
     * （/）斜杠，如 x/y，x 是开始值，y 是步长，比如在第一位（秒），0/15 就是从 0 秒开始，每隔 15 秒执行一次，最后就是 0、15、30、45、60，另
     * y，等同于 0/y。
     * 举几个例子熟悉一下:
     * <p>
     * 0 0 3**? ：每天 3点执行；
     * 0 5 3**?：每天 3点 5分执行；
     * 0 5 3?**：每天 3点 5分执行，与上面作用相同；
     * 0 5/10 3**?：每天 3点的 5分、15分、25分、35分、45分、55分这几个时间点执行；
     * 0 10 3?*1：每周星期天，3点 10分执行，注，1表示星期天；
     * 0 10 3?*1#3：每个月的第三个星期，星期天执行，#号只能出现在星期的位置。
     */
    private int count = 0;

    /**
     * @return void
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     **/
    @Scheduled(cron = "*/6 * * * * ?")
    private void process1() {
        System.out.println("this is scheduler task running " + (count++));
    }

    // 方式二----------------------------------------------------------

    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("HH:mm:ss");

    /**
     * @return void
     * @Description 设置没6秒执行一次
     * @Date 14:22 2019/1/24
     * @Param
     **/
    @Scheduled(fixedRate = 6000)
    private void process2() {
        System.out.println("now time is " + dateFormat.format(new Date()));
    }
}
