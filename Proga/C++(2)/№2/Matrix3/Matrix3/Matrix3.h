#pragma once
#include <iostream>
class Matrix3
{private:
	int **mem;
	int size;
public:
	Matrix3(int size_ = 0) {
		size = size_;
		mem = new int*[size];
		for (int i = 0; i < size; i++) {
			mem[i] = new int[size - i];
			for (int j = 0; j < size; j++) {
				mem[i][j] = 0;
			}
		}
	};


};

