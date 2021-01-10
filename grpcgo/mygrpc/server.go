package mygrpc

import "context"

/*
接口是：
type AddServiceServer interface {
	Add(context.Context, *AddRequest) (*AddReply, error)

	//如何实现接口继承呢？
	只要是实现里面的方法就是接口实现了
}
*/

type MyService struct {
}

func (s *MyService) Add(ctx context.Context, req *AddRequest) (*AddReply, error){
	res := myAdd(req.A, req.B)
	return &AddReply{Res:res}, nil
}

func myAdd(a int32, b int32) int32{
	return a+b
}