package com.xiaoping.server;

import com.xiaoping.server.pojo.Joblevel;
import com.xiaoping.server.service.IJoblevelService;
import javafx.beans.binding.ObjectBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小王造轮子
 * @description test
 * @date 2022/5/7
 */
@SpringBootTest
public class Test {

    @Autowired
    private IJoblevelService joblevelService;

    @org.junit.jupiter.api.Test
    public void test(){
        Joblevel joblevel = new Joblevel();
        joblevel.setId(9);
        joblevel.setName("asdf");
        joblevelService.updateById(joblevel);
    }

}
