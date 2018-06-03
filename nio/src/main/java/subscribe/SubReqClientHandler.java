package subscribe;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import pojo.SubscribeReq;
import pojo.SubscribeResp;

public class SubReqClientHandler extends ChannelHandlerAdapter {

    private int count;
    private byte[] req;

    public SubReqClientHandler(){
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for (int i = 0; i < 10; i++) {
            System.out.println(req(i));
            ctx.writeAndFlush(req(i));
        }
    }

    private SubscribeReq req (int subSeqId){
        SubscribeReq req = new SubscribeReq();
        req.setSubReqId(subSeqId);
        req.setUserName("xiasiyu");
        req.setAddress("辽宁阜新");
        req.setPhoneNumber("13099990000");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        SubscribeResp res = (SubscribeResp) msg;
        System.out.println("res is : " + res);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }

}
