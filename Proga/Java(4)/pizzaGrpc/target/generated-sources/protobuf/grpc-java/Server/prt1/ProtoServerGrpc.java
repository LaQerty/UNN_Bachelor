package Server.prt1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: Proto.proto")
public final class ProtoServerGrpc {

  private ProtoServerGrpc() {}

  public static final String SERVICE_NAME = "Server.prt1.ProtoServer";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      Server.prt1.Proto.getAllPizzaResponse> METHOD_GET_ALL_PIZZA =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, Server.prt1.Proto.getAllPizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "getAllPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.getAllPizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.addNewPizzaRequest,
      Server.prt1.Proto.addNewPizzaResponse> METHOD_ADD_NEW_PIZZA =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.addNewPizzaRequest, Server.prt1.Proto.addNewPizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "addNewPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.addNewPizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.addNewPizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.deletePizzaRequest,
      Server.prt1.Proto.deletePizzaResponse> METHOD_DELETE_PIZZA =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.deletePizzaRequest, Server.prt1.Proto.deletePizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "deletePizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.deletePizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.deletePizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.changeStatusToDoneRequest,
      Server.prt1.Proto.changeStatusToDoneResponse> METHOD_CHANGE_STATUS_TO_DONE =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.changeStatusToDoneRequest, Server.prt1.Proto.changeStatusToDoneResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "changeStatusToDone"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.changeStatusToDoneRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.changeStatusToDoneResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.changeStatusToAtWorkRequest,
      Server.prt1.Proto.changeStatusToAtWorkResponse> METHOD_CHANGE_STATUS_TO_AT_WORK =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.changeStatusToAtWorkRequest, Server.prt1.Proto.changeStatusToAtWorkResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "changeStatusToAtWork"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.changeStatusToAtWorkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.changeStatusToAtWorkResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.makeOrderRequest,
      Server.prt1.Proto.makeOrderResponse> METHOD_MAKE_ORDER =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.makeOrderRequest, Server.prt1.Proto.makeOrderResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "makeOrder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.makeOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.makeOrderResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Server.prt1.Proto.checkOrderRequest,
      Server.prt1.Proto.checkOrderResponse> METHOD_CHECK_ORDER =
      io.grpc.MethodDescriptor.<Server.prt1.Proto.checkOrderRequest, Server.prt1.Proto.checkOrderResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Server.prt1.ProtoServer", "checkOrder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.checkOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Server.prt1.Proto.checkOrderResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProtoServerStub newStub(io.grpc.Channel channel) {
    return new ProtoServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProtoServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProtoServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProtoServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProtoServerFutureStub(channel);
  }

  /**
   */
  public static abstract class ProtoServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllPizza(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.getAllPizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_PIZZA, responseObserver);
    }

    /**
     */
    public void addNewPizza(Server.prt1.Proto.addNewPizzaRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.addNewPizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NEW_PIZZA, responseObserver);
    }

    /**
     */
    public void deletePizza(Server.prt1.Proto.deletePizzaRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.deletePizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_PIZZA, responseObserver);
    }

    /**
     */
    public void changeStatusToDone(Server.prt1.Proto.changeStatusToDoneRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToDoneResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_STATUS_TO_DONE, responseObserver);
    }

    /**
     */
    public void changeStatusToAtWork(Server.prt1.Proto.changeStatusToAtWorkRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToAtWorkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_STATUS_TO_AT_WORK, responseObserver);
    }

    /**
     */
    public void makeOrder(Server.prt1.Proto.makeOrderRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.makeOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_ORDER, responseObserver);
    }

    /**
     */
    public void checkOrder(Server.prt1.Proto.checkOrderRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.checkOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_ORDER, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ALL_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                Server.prt1.Proto.getAllPizzaResponse>(
                  this, METHODID_GET_ALL_PIZZA)))
          .addMethod(
            METHOD_ADD_NEW_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.addNewPizzaRequest,
                Server.prt1.Proto.addNewPizzaResponse>(
                  this, METHODID_ADD_NEW_PIZZA)))
          .addMethod(
            METHOD_DELETE_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.deletePizzaRequest,
                Server.prt1.Proto.deletePizzaResponse>(
                  this, METHODID_DELETE_PIZZA)))
          .addMethod(
            METHOD_CHANGE_STATUS_TO_DONE,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.changeStatusToDoneRequest,
                Server.prt1.Proto.changeStatusToDoneResponse>(
                  this, METHODID_CHANGE_STATUS_TO_DONE)))
          .addMethod(
            METHOD_CHANGE_STATUS_TO_AT_WORK,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.changeStatusToAtWorkRequest,
                Server.prt1.Proto.changeStatusToAtWorkResponse>(
                  this, METHODID_CHANGE_STATUS_TO_AT_WORK)))
          .addMethod(
            METHOD_MAKE_ORDER,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.makeOrderRequest,
                Server.prt1.Proto.makeOrderResponse>(
                  this, METHODID_MAKE_ORDER)))
          .addMethod(
            METHOD_CHECK_ORDER,
            asyncUnaryCall(
              new MethodHandlers<
                Server.prt1.Proto.checkOrderRequest,
                Server.prt1.Proto.checkOrderResponse>(
                  this, METHODID_CHECK_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class ProtoServerStub extends io.grpc.stub.AbstractStub<ProtoServerStub> {
    private ProtoServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoServerStub(channel, callOptions);
    }

    /**
     */
    public void getAllPizza(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.getAllPizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addNewPizza(Server.prt1.Proto.addNewPizzaRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.addNewPizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePizza(Server.prt1.Proto.deletePizzaRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.deletePizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeStatusToDone(Server.prt1.Proto.changeStatusToDoneRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToDoneResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_STATUS_TO_DONE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeStatusToAtWork(Server.prt1.Proto.changeStatusToAtWorkRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToAtWorkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_STATUS_TO_AT_WORK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeOrder(Server.prt1.Proto.makeOrderRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.makeOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_ORDER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOrder(Server.prt1.Proto.checkOrderRequest request,
        io.grpc.stub.StreamObserver<Server.prt1.Proto.checkOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_ORDER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProtoServerBlockingStub extends io.grpc.stub.AbstractStub<ProtoServerBlockingStub> {
    private ProtoServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public Server.prt1.Proto.getAllPizzaResponse getAllPizza(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.addNewPizzaResponse addNewPizza(Server.prt1.Proto.addNewPizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NEW_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.deletePizzaResponse deletePizza(Server.prt1.Proto.deletePizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.changeStatusToDoneResponse changeStatusToDone(Server.prt1.Proto.changeStatusToDoneRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_STATUS_TO_DONE, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.changeStatusToAtWorkResponse changeStatusToAtWork(Server.prt1.Proto.changeStatusToAtWorkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_STATUS_TO_AT_WORK, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.makeOrderResponse makeOrder(Server.prt1.Proto.makeOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_ORDER, getCallOptions(), request);
    }

    /**
     */
    public Server.prt1.Proto.checkOrderResponse checkOrder(Server.prt1.Proto.checkOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_ORDER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProtoServerFutureStub extends io.grpc.stub.AbstractStub<ProtoServerFutureStub> {
    private ProtoServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.getAllPizzaResponse> getAllPizza(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.addNewPizzaResponse> addNewPizza(
        Server.prt1.Proto.addNewPizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.deletePizzaResponse> deletePizza(
        Server.prt1.Proto.deletePizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.changeStatusToDoneResponse> changeStatusToDone(
        Server.prt1.Proto.changeStatusToDoneRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_STATUS_TO_DONE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.changeStatusToAtWorkResponse> changeStatusToAtWork(
        Server.prt1.Proto.changeStatusToAtWorkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_STATUS_TO_AT_WORK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.makeOrderResponse> makeOrder(
        Server.prt1.Proto.makeOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_ORDER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Server.prt1.Proto.checkOrderResponse> checkOrder(
        Server.prt1.Proto.checkOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_ORDER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_PIZZA = 0;
  private static final int METHODID_ADD_NEW_PIZZA = 1;
  private static final int METHODID_DELETE_PIZZA = 2;
  private static final int METHODID_CHANGE_STATUS_TO_DONE = 3;
  private static final int METHODID_CHANGE_STATUS_TO_AT_WORK = 4;
  private static final int METHODID_MAKE_ORDER = 5;
  private static final int METHODID_CHECK_ORDER = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProtoServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProtoServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_PIZZA:
          serviceImpl.getAllPizza((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.getAllPizzaResponse>) responseObserver);
          break;
        case METHODID_ADD_NEW_PIZZA:
          serviceImpl.addNewPizza((Server.prt1.Proto.addNewPizzaRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.addNewPizzaResponse>) responseObserver);
          break;
        case METHODID_DELETE_PIZZA:
          serviceImpl.deletePizza((Server.prt1.Proto.deletePizzaRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.deletePizzaResponse>) responseObserver);
          break;
        case METHODID_CHANGE_STATUS_TO_DONE:
          serviceImpl.changeStatusToDone((Server.prt1.Proto.changeStatusToDoneRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToDoneResponse>) responseObserver);
          break;
        case METHODID_CHANGE_STATUS_TO_AT_WORK:
          serviceImpl.changeStatusToAtWork((Server.prt1.Proto.changeStatusToAtWorkRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.changeStatusToAtWorkResponse>) responseObserver);
          break;
        case METHODID_MAKE_ORDER:
          serviceImpl.makeOrder((Server.prt1.Proto.makeOrderRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.makeOrderResponse>) responseObserver);
          break;
        case METHODID_CHECK_ORDER:
          serviceImpl.checkOrder((Server.prt1.Proto.checkOrderRequest) request,
              (io.grpc.stub.StreamObserver<Server.prt1.Proto.checkOrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ProtoServerDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Server.prt1.Proto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProtoServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProtoServerDescriptorSupplier())
              .addMethod(METHOD_GET_ALL_PIZZA)
              .addMethod(METHOD_ADD_NEW_PIZZA)
              .addMethod(METHOD_DELETE_PIZZA)
              .addMethod(METHOD_CHANGE_STATUS_TO_DONE)
              .addMethod(METHOD_CHANGE_STATUS_TO_AT_WORK)
              .addMethod(METHOD_MAKE_ORDER)
              .addMethod(METHOD_CHECK_ORDER)
              .build();
        }
      }
    }
    return result;
  }
}
