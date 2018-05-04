package pojo;

import java.io.Serializable;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/05/04 7:34
 **/
public class SubscribeResp implements Serializable {
    private static final long serialVersionUID = 1L;
    //订购编号
    int subReqId;
    //返回码
    int respCode;
    //返回信息

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "subReqId=" + subReqId +
                ", respCode=" + respCode +
                ", respMsg='" + respMsg + '\'' +
                '}';
    }

    public int getSubReqId() {
        return subReqId;
    }

    public void setSubReqId(int subReqId) {
        this.subReqId = subReqId;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    String respMsg;
}
