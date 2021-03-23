package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {   //查询学生宿舍信息那块的数据库
    private boolean success;
    private String code;
    private String message;
    private Integer total;
    private Object data;
    private String stackTrace;
}
//以上为前端需要信息
