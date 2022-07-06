package club.beimeng.book_manage_keshe.utils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data /*生成get set*/
public class R {
    @ApiModelProperty(value = "是否成功le")
    private Boolean success;

    @ApiModelProperty(value = "返回de码")
    private Integer code;

    @ApiModelProperty(value = "返回de消息")
    private String message;

    @ApiModelProperty(value = "返回de数据")
    private Map<String,Object> data = new HashMap<>();

    /*把构造方法私有*/
    private R(){}

    /*成功静态方法*/
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(2000);
        r.setMessage("成功");
        return r;
    }
    /*失败静态方法*/
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(2001);
        r.setMessage("失败");
        return r;
    }

    /*返回自身可以做到链式编程*/
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
/*
 *
 * @author Mr.Bao
 * @date 2021/7/20 14:41
 */