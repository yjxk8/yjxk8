package com.zhfw.util;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component

public class CustomerKeyGenerator implements IKeyGenerator {

    /**
     * @param incrementerName 增量器名称，@KeySequence中的value之会传入该参数中
     * @return
     */
    @Override
    public String executeSql(String incrementerName) {
        return "select dms.F_SEQUENCE_GEN('" + incrementerName + "',1) from dual";
    }


    public static String getId() {
        //获取当前时间戳
        String str = String.valueOf(System.currentTimeMillis());
        List list = new ArrayList();
        //将时间戳放入到List中
        for (Character s : str.toCharArray()) {
            list.add(s.toString());
        }
        //随机打乱
        Collections.shuffle(list);
        //拼接字符串，并添加2(自定义)位随机数
        return String.join("", list) + randomNumber(2);
    }

    /**
     * 生成指定长度的一个数字字符串
     *
     * @param num
     * @return
     */
    public static String randomNumber(int num) {
        if (num < 1) {
            num = 1;
        }
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
