__kernel void arr_sum(__global int *arr)
{
	int global_id = get_global_id(0);
	arr[global_id] += global_id;
}

__kernel void message() {
	int global_id = get_global_id(0);
	int group_id = get_group_id(0);
	int local_id = get_local_id(0);
	printf("I am from %d block, %d thread (global index: %d)\n", group_id, local_id, global_id);
}