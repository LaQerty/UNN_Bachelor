__kernel void multiply(__global float *a, __global float *b, __global float *c, int m, int n, int k) {   
    int i = get_global_id(1);
    int j = get_global_id(0);
    float c_ = 0;
    for (int p = 0; p < n; p++)
        c_ += a[i * n + p] * b[j + k * p];
    c[k * i + j] = c_;
}

__kernel void multiplyOptimal(__global float *a, __global float *b, __global float *c, int m, int n, int k) {
	__local float A[16][16];
    __local float B[16][16];
    int local_j = get_local_id(1);
    int local_i = get_local_id(0);
    int j = get_global_id(1);
    int i = get_global_id(0);
    int blocks = m / 16;
    float c_ = 0;
    for (int p = 0; p < blocks; p++) {
        A[local_j][local_i] = a[j * m + 16 * p + local_i];
        B[local_j][local_i] = b[(local_j + 16 * p) * n + i];
        barrier(CLK_LOCAL_MEM_FENCE);
        for (int p = 0; p < 16; p++)
            c_ += A[local_j][p] * B[p][local_i];
        barrier(CLK_LOCAL_MEM_FENCE);
    }
    c[i + j * k] = c_;
}

__kernel void multiplyImage(__read_only image2d_t a, __read_only image2d_t b, __write_only image2d_t c, int m, int n, int k) {
    __local float A[16][16];
    __local float B[16][16];
    int local_i = get_local_id(0);
    int local_j = get_local_id(1);
    int i = get_global_id(0);
    int j = get_global_id(1);
    int blocks = m / 16;
    float c_ = 0;
    for (int p = 0; p < blocks; p++) {
        float x = read_imagef(a, (int2)(16 * p + local_i, j)).x;
        float y = read_imagef(b, (int2)(i, 16 * p + local_j)).x;
        A[local_j][local_i] = x;
        B[local_j][local_i] = y;
        barrier(CLK_LOCAL_MEM_FENCE);
        for (int p = 0; p < 16; p++)
            c_ += A[local_j][p] * B[p][local_i];
        barrier(CLK_LOCAL_MEM_FENCE);
    }
    write_imagef(c, (int2)(i, j), c_);
}