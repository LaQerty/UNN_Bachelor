#include <CL/cl.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <numeric>


std::string createSource(const std::string &path) {
	std::ifstream file(path);
	std::string content, str;
	while (std::getline(file, str)) {
		content += str;
		content.push_back('\n');
	}
	return content;
}

int main() {
	cl_uint platformCount = 0;
	clGetPlatformIDs(0, nullptr, &platformCount);
	cl_platform_id* platform = new cl_platform_id[platformCount];
	clGetPlatformIDs(platformCount, platform, nullptr);

	for (cl_uint i = 0; i < platformCount; ++i) {
		char platformName[128];
		char platformVersion[128];
		char platformVendor[128];
		clGetPlatformInfo(platform[i], CL_PLATFORM_NAME, 128, platformName, nullptr);
		clGetPlatformInfo(platform[i], CL_PLATFORM_VERSION, 128, platformVersion, nullptr);
		clGetPlatformInfo(platform[i], CL_PLATFORM_VENDOR, 128, platformVendor, nullptr);
		std::cout << platformName << " " << platformVersion << " " << platformVendor << std::endl;
	}

	cl_device_id deviceId = 0;
	cl_uint deviceCount = 0;
	char deviceName[128];
	clGetDeviceIDs(platform[0], CL_DEVICE_TYPE_GPU, 1, &deviceId, &deviceCount);
	clGetDeviceInfo(deviceId, CL_DEVICE_NAME, 128, deviceName, nullptr);
	std::cout << deviceName << std::endl;

	cl_context context = clCreateContext(nullptr, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_command_queue queue = clCreateCommandQueueWithProperties(context, deviceId, 0, nullptr);
	std::string source;
	const char *strings;
	cl_program program;
	cl_kernel kernel;

	source = createSource("OpenCLFile.cl");
	strings = { source.c_str() };
	program = clCreateProgramWithSource(context, 1, &strings, nullptr, nullptr);
	clBuildProgram(program, 1, &deviceId, nullptr, nullptr, nullptr);
	kernel = clCreateKernel(program, "message", nullptr);
	const size_t glob = 75;
	const size_t loc = 15;
	clEnqueueNDRangeKernel(queue, kernel, 1, nullptr, &glob, &loc, 0, nullptr, nullptr);

	const size_t n = 10;
	std::vector<cl_uint> arr(n, 0);
	cl_mem memory = nullptr;

	source = createSource("OpenCLFile.cl");
	strings = { source.c_str() };
	program = clCreateProgramWithSource(context, 1, &strings, nullptr, nullptr);
	clBuildProgram(program, 1, &deviceId, nullptr, nullptr, nullptr);
	kernel = clCreateKernel(program, "arr_sum", nullptr);

	memory = clCreateBuffer(context, CL_MEM_READ_WRITE, n * sizeof(cl_int), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, memory, CL_TRUE, 0, n * sizeof(cl_int), arr.data(), 0, nullptr, nullptr);
	clSetKernelArg(kernel, 0, sizeof(cl_mem), (void *)&memory);

	clEnqueueNDRangeKernel(queue, kernel, 1, nullptr, &n, nullptr, 0, nullptr, nullptr);
	clEnqueueReadBuffer(queue, memory, CL_TRUE, 0, n * sizeof(cl_int), arr.data(), 0, nullptr, nullptr);

	for (int i = 0; i < arr.size(); i++) std::cout << arr[i] << ' ';
	std::cout << std::endl;

	clReleaseMemObject(memory);
	clReleaseKernel(kernel);
	clReleaseProgram(program);
	clReleaseCommandQueue(queue);
	clReleaseContext(context);
	delete[] platform;
	system("pause");
}