package com.music.musicplatform.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    private Integer code;        // 状态码，200成功，其他失败
    private String message;      // 提示信息
    private T data;              // 返回的数据

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> fail(String message) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}