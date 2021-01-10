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

    //������
    public static void main(String[] args) {
        int a = 101;
        int b = 102;
        AddClient client = new AddClient();

        AddReply reply =
                client.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(reply.getRes());
    }

    //���췽��
    public AddClient(){
        channel = ManagedChannelBuilder
                .forAddress("127.0.0.1",9999)
                .usePlaintext()//���ı�����
                .build();
        //����һ��׮�ӣ�ʵ���ϲ����Ǵ��ݸ�stub��Ȼ��stub���������ʽ���������ݵ������
        stub =
                AddServiceGrpc.newBlockingStub(channel);
    }
}