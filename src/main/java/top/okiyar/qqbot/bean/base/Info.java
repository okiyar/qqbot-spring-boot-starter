package top.okiyar.qqbot.bean.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Info {
    private Integer retcode;
    private String status;
    private String echo;
}
