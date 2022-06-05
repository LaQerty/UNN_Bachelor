#define CL_USE_DEPRECATED_OPENCL_1_1_APIS
#include <CL/cl.h>
#include <CL/opencl.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <numeric>
#include <omp.h>
#include <random>
#include <algorithm>
#include <ctime>

std::string createSource(const std::string &path) {
	std::ifstream file(path);
	std::string content, str;
	while (std::getline(file, str)) {
		content += str;
		content.push_back('\n');
	}
	return content;
}

template <typename T>
void getVector(std::vector <T> &vec, int k) {
	std::mt19937 gen;
	gen.seed(static_cast<unsigned int>(k));
	for (int i = 0; i < vec.size(); i++)
		vec[i] = gen() % 100;
}


void multiply(float *a, float *b, float *c, int m, int n, int k) {
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < k; j++) {
			float c_ = 0;
			for (int p = 0; p < n; p++)
				c_ += a[i * n + p] * b[p*k + j];
			c[i*k + j] = c_;
		}
	}
}

void multiply_omp(float *a, float *b, float *c, int m, int n, int k) {
#pragma omp parallel for
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < k; j++) {
			float c_ = 0;
			for (int p = 0; p < n; p++)
				c_ += a[i * n + p] * b[p*k + j];
			c[i*k + j] = c_;
		}
	}
}


void multiply_cl(float *a, float *b, float *c, int m, int n, int k, cl_device_id deviceId) {
	cl_context context = clCreateContext(nullptr, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_command_queue queue = clCreateCommandQueueWithProperties(context, deviceId, 0, nullptr);

	std::string source = createSource("OpenCLFile.cl");
	const char *strings[] = { source.c_str() };
	cl_program program = clCreateProgramWithSource(context, 1, strings, nullptr, nullptr);
	clBuildProgram(program, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_kernel kernel = clCreateKernel(program, "multiply", nullptr);

	cl_mem a_memory = clCreateBuffer(context, CL_MEM_READ_ONLY, m * n * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, a_memory, CL_TRUE, 0, m * n * sizeof(float), a, 0, nullptr, nullptr);
	cl_mem b_memory = clCreateBuffer(context, CL_MEM_READ_ONLY, n * k * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, b_memory, CL_TRUE, 0, n * k * sizeof(float), b, 0, nullptr, nullptr);
	cl_mem c_memory = clCreateBuffer(context, CL_MEM_READ_WRITE, m * k * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, c_memory, CL_TRUE, 0, m * k * sizeof(float), c, 0, nullptr, nullptr);

	clSetKernelArg(kernel, 0, sizeof(cl_mem), &a_memory);
	clSetKernelArg(kernel, 1, sizeof(cl_mem), &b_memory);
	clSetKernelArg(kernel, 2, sizeof(cl_mem), &c_memory);
	clSetKernelArg(kernel, 3, sizeof(int), &m);
	clSetKernelArg(kernel, 4, sizeof(int), &n);
	clSetKernelArg(kernel, 5, sizeof(int), &k);

	size_t globalWorkSize[] = { static_cast<size_t>(m), static_cast<size_t>(k) };
	size_t localWorkSize[] = { 16, 16 };
	double begin = omp_get_wtime();
	clEnqueueNDRangeKernel(queue, kernel, 2, nullptr, globalWorkSize, localWorkSize, 0, nullptr, nullptr);
	clFinish(queue);
	double end = omp_get_wtime();
	std::cout << "opencl time: " << end - begin << std::endl;

	clEnqueueReadBuffer(queue, c_memory, CL_TRUE, 0, m * k * sizeof(float), c, 0, nullptr, nullptr);

	clReleaseMemObject(a_memory);
	clReleaseMemObject(b_memory);
	clReleaseMemObject(c_memory);
	clReleaseKernel(kernel);
	clReleaseProgram(program);
	clReleaseCommandQueue(queue);
	clReleaseContext(context);
}


void multiplyOptimal_cl(float *a, float *b, float *c, int m, int n, int k, cl_device_id deviceId) {
	cl_context context = clCreateContext(nullptr, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_command_queue queue = clCreateCommandQueueWithProperties(context, deviceId, 0, nullptr);

	std::string source = createSource("OpenCLFile.cl");
	const char *strings[] = { source.c_str() };
	cl_program program = clCreateProgramWithSource(context, 1, strings, nullptr, nullptr);
	clBuildProgram(program, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_kernel kernel = clCreateKernel(program, "multiplyOptimal", nullptr);

	cl_mem a_memory = clCreateBuffer(context, CL_MEM_READ_ONLY, m * n * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, a_memory, CL_TRUE, 0, m * n * sizeof(float), a, 0, nullptr, nullptr);
	cl_mem b_memory = clCreateBuffer(context, CL_MEM_READ_ONLY, n * k * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, b_memory, CL_TRUE, 0, n * k * sizeof(float), b, 0, nullptr, nullptr);
	cl_mem c_memory = clCreateBuffer(context, CL_MEM_READ_WRITE, m * k * sizeof(float), nullptr, nullptr);
	clEnqueueWriteBuffer(queue, c_memory, CL_TRUE, 0, m * k * sizeof(float), c, 0, nullptr, nullptr);

	clSetKernelArg(kernel, 0, sizeof(cl_mem), &a_memory);
	clSetKernelArg(kernel, 1, sizeof(cl_mem), &b_memory);
	clSetKernelArg(kernel, 2, sizeof(cl_mem), &c_memory);
	clSetKernelArg(kernel, 3, sizeof(int), &m);
	clSetKernelArg(kernel, 4, sizeof(int), &n);
	clSetKernelArg(kernel, 5, sizeof(int), &k);

	size_t globalWorkSize[] = { static_cast<size_t>(m), static_cast<size_t>(k) };
	size_t localWorkSize[] = { 16, 16 };
	double begin = omp_get_wtime();
	clEnqueueNDRangeKernel(queue, kernel, 2, nullptr, globalWorkSize, localWorkSize, 0, nullptr, nullptr);
	clFinish(queue);
	double end = omp_get_wtime();
	std::cout << "opencl optimized time: " << end - begin << std::endl;

	clEnqueueReadBuffer(queue, c_memory, CL_TRUE, 0, m * k * sizeof(float), c, 0, nullptr, nullptr);

	clReleaseMemObject(a_memory);
	clReleaseMemObject(b_memory);
	clReleaseMemObject(c_memory);
	clReleaseKernel(kernel);
	clReleaseProgram(program);
	clReleaseCommandQueue(queue);
	clReleaseContext(context);
}


void multiplyImage_cl(float *a, float *b, float *c, int m, int n, int k, cl_device_id deviceId) {
	cl_context context = clCreateContext(nullptr, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_command_queue queue = clCreateCommandQueueWithProperties(context, deviceId, 0, nullptr);

	std::string source = createSource("OpenCLFile.cl");
	const char *strings[] = { source.c_str() };
	cl_program program = clCreateProgramWithSource(context, 1, strings, nullptr, nullptr);
	clBuildProgram(program, 1, &deviceId, nullptr, nullptr, nullptr);
	cl_kernel kernel = clCreateKernel(program, "multiplyImage", nullptr);

	cl_image_format format;
	format.image_channel_order = CL_R;
	format.image_channel_data_type = CL_FLOAT;

	/*cl_image_desc image_desc1;
	image_desc1.image_type = CL_MEM_OBJECT_IMAGE2D;
	image_desc1.image_width = static_cast<size_t>(m);
	image_desc1.image_height = static_cast<size_t>(n);


	cl_image_desc image_desc2;
	image_desc2.image_type = CL_MEM_OBJECT_IMAGE2D;
	image_desc2.image_width = static_cast<size_t>(k);
	image_desc2.image_height = static_cast<size_t>(n);



	cl_image_desc image_desc3;
	image_desc3.image_type = CL_MEM_OBJECT_IMAGE2D;
	image_desc3.image_width = static_cast<size_t>(k);
	image_desc3.image_height = static_cast<size_t>(m);

	cl_int ret;*/

	//cl_mem a_memory = clCreateImage(context, CL_MEM_READ_ONLY | CL_MEM_ALLOC_HOST_PTR | CL_MEM_COPY_HOST_PTR, &format, &image_desc1, nullptr, nullptr);
	//std::cout << ret;
	//cl_mem b_memory = clCreateImage(context, CL_MEM_READ_ONLY | CL_MEM_ALLOC_HOST_PTR | CL_MEM_COPY_HOST_PTR, &format, &image_desc2, nullptr, nullptr);
	//cl_mem c_memory = clCreateImage(context, CL_MEM_WRITE_ONLY | CL_MEM_ALLOC_HOST_PTR | CL_MEM_COPY_HOST_PTR, &format, &image_desc3, nullptr,  nullptr);

	cl_mem a_memory = clCreateImage2D(context, CL_MEM_READ_ONLY, &format, static_cast<size_t>(m), static_cast<size_t>(n), 0, nullptr, nullptr);
	cl_mem b_memory = clCreateImage2D(context, CL_MEM_READ_ONLY, &format, static_cast<size_t>(n), static_cast<size_t>(k), 0, nullptr, nullptr);
	cl_mem c_memory = clCreateImage2D(context, CL_MEM_WRITE_ONLY, &format, static_cast<size_t>(m), static_cast<size_t>(k), 0, nullptr, nullptr);

	size_t origin[] = { 0, 0, 0 };
	size_t region1[] = { static_cast<size_t>(m), static_cast<size_t>(n), 1 };
	clEnqueueWriteImage(queue, a_memory, CL_TRUE, origin, region1, 0, 0, a, 0, nullptr, nullptr);

	size_t region2[] = { static_cast<size_t>(n), static_cast<size_t>(k), 1 };
	clEnqueueWriteImage(queue, b_memory, CL_TRUE, origin, region2, 0, 0, b, 0, nullptr, nullptr);

	clSetKernelArg(kernel, 0, sizeof(cl_mem), &a_memory);
	clSetKernelArg(kernel, 1, sizeof(cl_mem), &b_memory);
	clSetKernelArg(kernel, 2, sizeof(cl_mem), &c_memory);
	clSetKernelArg(kernel, 3, sizeof(int), &m);
	clSetKernelArg(kernel, 4, sizeof(int), &n);
	clSetKernelArg(kernel, 5, sizeof(int), &k);

	size_t globalWorkSize[] = { static_cast<size_t>(m), static_cast<size_t>(k) };
	size_t localWorkSize[] = { 16, 16 };
	double begin = omp_get_wtime();
	clEnqueueNDRangeKernel(queue, kernel, 2, nullptr, globalWorkSize, localWorkSize, 0, nullptr, nullptr);
	clFinish(queue);
	double end = omp_get_wtime();
	std::cout << "opencl image time: " << end - begin << std::endl;

	size_t region3[] = { static_cast<size_t>(m),  static_cast<size_t>(k), 1 };
	clEnqueueReadImage(queue, c_memory, CL_TRUE, origin, region3, 0, 0, c, 0, nullptr, nullptr);


	clReleaseMemObject(a_memory);
	clReleaseMemObject(b_memory);
	clReleaseMemObject(c_memory);
	clReleaseKernel(kernel);
	clReleaseProgram(program);
	clReleaseCommandQueue(queue);
	clReleaseContext(context);
}

int main() {

	cl_uint platformCount = 0;
	clGetPlatformIDs(0, nullptr, &platformCount);
	cl_platform_id *platform = new cl_platform_id[platformCount];
	clGetPlatformIDs(platformCount, platform, nullptr);

	char deviceName[128];
	char platformName[128];
	cl_device_id cpuDeviceId = 0;
	cl_uint deviceCount = 0;
	cl_device_id gpuDeviceId = 0;

	clGetDeviceIDs(platform[0], CL_DEVICE_TYPE_CPU, 1, &cpuDeviceId, &deviceCount);
	clGetDeviceInfo(cpuDeviceId, CL_DEVICE_NAME, 128, deviceName, nullptr);
	std::cout << deviceName << std::endl;

	clGetDeviceIDs(platform[1], CL_DEVICE_TYPE_GPU, 1, &gpuDeviceId, &deviceCount);
	clGetDeviceInfo(gpuDeviceId, CL_DEVICE_NAME, 128, deviceName, nullptr);
	std::cout << deviceName << std::endl;

	constexpr int m = 1024;
	constexpr int n = 1024;
	constexpr int k = 1024;

	std::vector<float> a(m * n);
	std::vector<float> b(n * k);
	std::vector<float> c(m * k);

	getVector(a, 1);
	getVector(b, 2);

	double begin = omp_get_wtime();
	multiply(a.data(), b.data(), c.data(), m, n, k);
	double end = omp_get_wtime();
	std::cout << "seq time: " << end - begin << std::endl;

	std::vector<float> c1(m * k);
	begin = omp_get_wtime();
	multiply_omp(a.data(), b.data(), c1.data(), m, n, k);
	end = omp_get_wtime();
	std::cout << "omp time: " << end - begin << std::endl;
	if (c1 == c) std::cout << "omp result correct" << std::endl << std::endl;


	std::cout << "GPU:" << std::endl;
	std::vector<float> c2(m * k);
	multiply_cl(a.data(), b.data(), c2.data(), m, n, k, gpuDeviceId);
	if (c2 == c) std::cout << "opencl result correct" << std::endl;

	std::vector<float> c3(m * k);
	multiplyOptimal_cl(a.data(), b.data(), c3.data(), m, n, k, gpuDeviceId);
	if (c3 == c) std::cout << "opencl optimized result correct" << std::endl;

	std::vector<float> c4(m * k);
	multiplyImage_cl(a.data(), b.data(), c4.data(), m, n, k, gpuDeviceId);
	if (c4 == c) std::cout << "opencl image result correct" << std::endl << std::endl;

	std::cout << "CPU:" << std::endl;
	std::vector<float> c5(m * k);
	multiply_cl(a.data(), b.data(), c5.data(), m, n, k, cpuDeviceId);
	if (c2 == c) std::cout << "opencl result correct" << std::endl;

	std::vector<float> c6(m * k);
	multiplyOptimal_cl(a.data(), b.data(), c6.data(), m, n, k, cpuDeviceId);
	if (c3 == c) std::cout << "opencl optimized result correct" << std::endl;

	std::vector<float> c7(m * k);
	multiplyImage_cl(a.data(), b.data(), c7.data(), m, n, k, cpuDeviceId);
	if (c4 == c) std::cout << "opencl image result correct" << std::endl;


	delete[] platform;
	system("pause");
}