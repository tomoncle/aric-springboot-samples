package com.aric.tomcat.rest.controller;

import com.aric.tomcat.rest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数类型见：io.swagger.models.paramters --> (query,path,body,form ...)
 * <p/>
 * 即使方法上不加 @ApiOperation 等这样的注解，
 * 只要类上加了 @Api 注解，要解析的方法上有：@RequestMapping，@RequestParam这样的Spring注解，
 * swagger也会默认帮你解析参数。都使用默认值。
 * <p/>
 * 参考：https://github.com/springfox/springfox/issues/902
 * Created by tom.lee on 2017/12/2.
 */
@Api(value = "用户信息", tags = {"users-api"})
@RestController
@RequestMapping("/rest/v1/users")
public class RestDataController {
    private static Logger logger = LoggerFactory.getLogger(RestDataController.class);

    /**
     * data = {'username':'test'}
     * d = requests.get(url, params=data)
     * <p/>
     * 查询
     *
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "用户列表", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET)
    List<User> list() {
        logger.info("call users");
        return new ArrayList<>();
    }

    /**
     * data = {'username':'test'}
     * d = requests.post(url, data=data)
     * <p/>
     * 创建
     *
     * @param username RequestParam 传递参数在data位置
     * @return
     */
    @ApiOperation(value = "用户新增", notes = "用户新增", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", dataType = "string", required = true, paramType = "form"),
    })
    @RequestMapping(method = RequestMethod.POST)
    int create(@RequestParam String username) {
        logger.info("call user save");
        logger.info(new User(username).toString());
        return 1;
    }

    /**
     * data = {'username':'test'}
     * d = requests.put(url, data=data)
     * 编辑
     *
     * @param username RequestParam 传递参数在data位置
     * @return
     */
    @ApiOperation(value = "用户编辑", notes = "用户编辑", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", dataType = "string", required = true, paramType = "form"),
    })
    @RequestMapping(method = RequestMethod.PUT)
    int update(@RequestParam String username) {
        logger.info("call user update");
        logger.info(new User(username).toString());
        return 1;
    }

    /**
     * username = 'test'
     * d = requests.delete('/rest/v1/users/' + )
     * <p/>
     * 删除
     *
     * @param username PathVariable
     * @return
     */
    @ApiOperation(value = "用户删除", notes = "用户删除", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", dataType = "string", required = true, paramType = "path"),
    })
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    int delete(@PathVariable("username") String username) {
        logger.info("call user delete");
        logger.info(new User(username).toString());
        return 1;
    }

    /**
     * d = requests.post(
     * url='http://localhost:8086/rest/v1/users/batch',
     * headers={'dataType': 'json', 'content-type': 'application/json'},
     * json=[{'username': 'test'},{'username': 'develop'}]
     * )
     * <p/>
     * 批量操作
     *
     * @param users 传递参数在body位置, @RequestBody注解将json数组转为Java集合
     * @return
     */
    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    int createBatch(@RequestBody List<User> users) {
        for (User user : users) {
            logger.info("call user =" + user.toString());
        }
        return 1;
    }

}
