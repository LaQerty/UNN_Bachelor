package ClientServer.prt1;

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

  public static final String SERVICE_NAME = "ClientServer.prt1.ProtoServer";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.addFileRequest,
      ClientServer.prt1.Proto.addFileResponse> METHOD_ADD_FILE =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.addFileRequest, ClientServer.prt1.Proto.addFileResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "addFile"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.addFileRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.addFileResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.getIdForEstimateRequest,
      ClientServer.prt1.Proto.getIdForEstimateResponse> METHOD_GET_ID_FOR_ESTIMATE =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.getIdForEstimateRequest, ClientServer.prt1.Proto.getIdForEstimateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "getIdForEstimate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getIdForEstimateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getIdForEstimateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.getFileRequest,
      ClientServer.prt1.Proto.getFileResponse> METHOD_GET_FILE =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.getFileRequest, ClientServer.prt1.Proto.getFileResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "getFile"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getFileRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getFileResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.setMarkRequest,
      ClientServer.prt1.Proto.setMarkResponse> METHOD_SET_MARK =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.setMarkRequest, ClientServer.prt1.Proto.setMarkResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "setMark"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.setMarkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.setMarkResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.getAverageMarkRequest,
      ClientServer.prt1.Proto.getAverageMarkResponse> METHOD_GET_AVERAGE_MARK =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.getAverageMarkRequest, ClientServer.prt1.Proto.getAverageMarkResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "getAverageMark"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getAverageMarkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getAverageMarkResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ClientServer.prt1.Proto.getAllLabResponse> METHOD_GET_ALL_LAB =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ClientServer.prt1.Proto.getAllLabResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "getAllLab"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getAllLabResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ClientServer.prt1.Proto.getAllMarkRequest,
      ClientServer.prt1.Proto.getAllMarkResponse> METHOD_GET_ALL_MARK =
      io.grpc.MethodDescriptor.<ClientServer.prt1.Proto.getAllMarkRequest, ClientServer.prt1.Proto.getAllMarkResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ClientServer.prt1.ProtoServer", "getAllMark"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getAllMarkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ClientServer.prt1.Proto.getAllMarkResponse.getDefaultInstance()))
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
    public void addFile(ClientServer.prt1.Proto.addFileRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.addFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_FILE, responseObserver);
    }

    /**
     */
    public void getIdForEstimate(ClientServer.prt1.Proto.getIdForEstimateRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getIdForEstimateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ID_FOR_ESTIMATE, responseObserver);
    }

    /**
     */
    public void getFile(ClientServer.prt1.Proto.getFileRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FILE, responseObserver);
    }

    /**
     */
    public void setMark(ClientServer.prt1.Proto.setMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.setMarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_MARK, responseObserver);
    }

    /**
     */
    public void getAverageMark(ClientServer.prt1.Proto.getAverageMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAverageMarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_AVERAGE_MARK, responseObserver);
    }

    /**
     */
    public void getAllLab(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllLabResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_LAB, responseObserver);
    }

    /**
     */
    public void getAllMark(ClientServer.prt1.Proto.getAllMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllMarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_MARK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_FILE,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.addFileRequest,
                ClientServer.prt1.Proto.addFileResponse>(
                  this, METHODID_ADD_FILE)))
          .addMethod(
            METHOD_GET_ID_FOR_ESTIMATE,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.getIdForEstimateRequest,
                ClientServer.prt1.Proto.getIdForEstimateResponse>(
                  this, METHODID_GET_ID_FOR_ESTIMATE)))
          .addMethod(
            METHOD_GET_FILE,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.getFileRequest,
                ClientServer.prt1.Proto.getFileResponse>(
                  this, METHODID_GET_FILE)))
          .addMethod(
            METHOD_SET_MARK,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.setMarkRequest,
                ClientServer.prt1.Proto.setMarkResponse>(
                  this, METHODID_SET_MARK)))
          .addMethod(
            METHOD_GET_AVERAGE_MARK,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.getAverageMarkRequest,
                ClientServer.prt1.Proto.getAverageMarkResponse>(
                  this, METHODID_GET_AVERAGE_MARK)))
          .addMethod(
            METHOD_GET_ALL_LAB,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ClientServer.prt1.Proto.getAllLabResponse>(
                  this, METHODID_GET_ALL_LAB)))
          .addMethod(
            METHOD_GET_ALL_MARK,
            asyncUnaryCall(
              new MethodHandlers<
                ClientServer.prt1.Proto.getAllMarkRequest,
                ClientServer.prt1.Proto.getAllMarkResponse>(
                  this, METHODID_GET_ALL_MARK)))
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
    public void addFile(ClientServer.prt1.Proto.addFileRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.addFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_FILE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIdForEstimate(ClientServer.prt1.Proto.getIdForEstimateRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getIdForEstimateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ID_FOR_ESTIMATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFile(ClientServer.prt1.Proto.getFileRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FILE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMark(ClientServer.prt1.Proto.setMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.setMarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_MARK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAverageMark(ClientServer.prt1.Proto.getAverageMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAverageMarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_AVERAGE_MARK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllLab(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllLabResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_LAB, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllMark(ClientServer.prt1.Proto.getAllMarkRequest request,
        io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllMarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_MARK, getCallOptions()), request, responseObserver);
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
    public ClientServer.prt1.Proto.addFileResponse addFile(ClientServer.prt1.Proto.addFileRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_FILE, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.getIdForEstimateResponse getIdForEstimate(ClientServer.prt1.Proto.getIdForEstimateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ID_FOR_ESTIMATE, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.getFileResponse getFile(ClientServer.prt1.Proto.getFileRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FILE, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.setMarkResponse setMark(ClientServer.prt1.Proto.setMarkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_MARK, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.getAverageMarkResponse getAverageMark(ClientServer.prt1.Proto.getAverageMarkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_AVERAGE_MARK, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.getAllLabResponse getAllLab(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_LAB, getCallOptions(), request);
    }

    /**
     */
    public ClientServer.prt1.Proto.getAllMarkResponse getAllMark(ClientServer.prt1.Proto.getAllMarkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_MARK, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.addFileResponse> addFile(
        ClientServer.prt1.Proto.addFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_FILE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.getIdForEstimateResponse> getIdForEstimate(
        ClientServer.prt1.Proto.getIdForEstimateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ID_FOR_ESTIMATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.getFileResponse> getFile(
        ClientServer.prt1.Proto.getFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FILE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.setMarkResponse> setMark(
        ClientServer.prt1.Proto.setMarkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_MARK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.getAverageMarkResponse> getAverageMark(
        ClientServer.prt1.Proto.getAverageMarkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_AVERAGE_MARK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.getAllLabResponse> getAllLab(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_LAB, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ClientServer.prt1.Proto.getAllMarkResponse> getAllMark(
        ClientServer.prt1.Proto.getAllMarkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_MARK, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_FILE = 0;
  private static final int METHODID_GET_ID_FOR_ESTIMATE = 1;
  private static final int METHODID_GET_FILE = 2;
  private static final int METHODID_SET_MARK = 3;
  private static final int METHODID_GET_AVERAGE_MARK = 4;
  private static final int METHODID_GET_ALL_LAB = 5;
  private static final int METHODID_GET_ALL_MARK = 6;

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
        case METHODID_ADD_FILE:
          serviceImpl.addFile((ClientServer.prt1.Proto.addFileRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.addFileResponse>) responseObserver);
          break;
        case METHODID_GET_ID_FOR_ESTIMATE:
          serviceImpl.getIdForEstimate((ClientServer.prt1.Proto.getIdForEstimateRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getIdForEstimateResponse>) responseObserver);
          break;
        case METHODID_GET_FILE:
          serviceImpl.getFile((ClientServer.prt1.Proto.getFileRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getFileResponse>) responseObserver);
          break;
        case METHODID_SET_MARK:
          serviceImpl.setMark((ClientServer.prt1.Proto.setMarkRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.setMarkResponse>) responseObserver);
          break;
        case METHODID_GET_AVERAGE_MARK:
          serviceImpl.getAverageMark((ClientServer.prt1.Proto.getAverageMarkRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAverageMarkResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_LAB:
          serviceImpl.getAllLab((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllLabResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MARK:
          serviceImpl.getAllMark((ClientServer.prt1.Proto.getAllMarkRequest) request,
              (io.grpc.stub.StreamObserver<ClientServer.prt1.Proto.getAllMarkResponse>) responseObserver);
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
      return ClientServer.prt1.Proto.getDescriptor();
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
              .addMethod(METHOD_ADD_FILE)
              .addMethod(METHOD_GET_ID_FOR_ESTIMATE)
              .addMethod(METHOD_GET_FILE)
              .addMethod(METHOD_SET_MARK)
              .addMethod(METHOD_GET_AVERAGE_MARK)
              .addMethod(METHOD_GET_ALL_LAB)
              .addMethod(METHOD_GET_ALL_MARK)
              .build();
        }
      }
    }
    return result;
  }
}
