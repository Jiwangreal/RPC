package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Frank
 * @date 2021/1/9 16:28
 */
public class AddClient {
    AddServiceGrpc.AddServiceBlockingStub stub;
    ManagedChannel channel;

    //主方法
    public static void main(String[] args) {
        int a = 101;
        int b = 102;
        AddClient client = new AddClient();

        AddReply reply =
                client.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(reply.getRes());
    }

    //构造方法
    public AddClient(){
        channel = ManagedChannelBuilder
                .forAddress("127.0.0.1",9999)
                .usePlaintext()//纯文本类型
                .build();
        //创建一个桩子：实际上参数是传递给stub，然后stub以网络的形式将参数传递到服务端
        stub =
                AddServiceGrpc.newBlockingStub(channel);
    }
}