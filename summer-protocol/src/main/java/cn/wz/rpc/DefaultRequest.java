package cn.wz.rpc;


import lombok.Data;

import java.io.Serializable;

@Data
public class DefaultRequest implements Serializable {
    private static final long serialVersionUID = 6777332257932913864L;

    private String interfaceName;
    private String methodName;
    private String paramtersDesc;
    private Object[] arguments;
    private long requestId;

}
