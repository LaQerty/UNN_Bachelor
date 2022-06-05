#pragma once
#include "Header.h"
#include <iostream>
#include <string>

using namespace std;

template <class T>
class TMatrix
{
private:
	Tvector< Tvector<T> > matrix;
	int size;
public:
	TMatrix<T>(int _size = 0) {
		this->size = _size;
		this->matrix = Tvector<Tvector<T>>(this->size);
		for (int i = 0; i < this->size; i++) {
			matrix[i] = Tvector<T>(this->size - i, i);
		}
	}

	TMatrix<T>(const TMatrix<T> &tmp) {
		this->size = tmp.size;
		this->matrix = tmp.matrix;
	}

	~TMatrix() {}

	TMatrix<T> &operator= (const TMatrix<T> &tmp) {
		if (this->size != tmp.size) {
			if (this->size) {
				this->matrix = Tvector<Tvector<T>>(0);
				this->matrix = Tvector< Tvector<T> >(tmp.size);
			}
			this->size = tmp.size;
		}
		matrix = tmp.matrix;
		return (*this);
	}

	Tvector<T> &operator[] (const int k) {
		if (k < 0 || k >= this->size) throw - 1;
		return this->matrix[k];
	}

	TMatrix<T> operator* (TMatrix<T> &tmp) {
		if (tmp.size != this->size) throw - 1;
		TMatrix<T> res(this->size);
		for (int i = 0; i < this->size; i++) {
			for (int j = i; j < this->size; j++) {
				for (int k = i; k <= j; k++) {
					T m = tmp.matrix[k][j];
					m *= this->matrix[i][k];
					res[i][j] += m;
				}
			}
		}
		return res;
	}

	TMatrix operator+ (TMatrix<T> &tmp) {
		if (this->size != tmp.size) throw - 1;
		TMatrix<T> res(this->size);
		res.matrix = this->matrix + tmp.matrix;
		return res;
	}

	TMatrix operator- (TMatrix<T> &tmp) {
		if (this->size != tmp.size) throw - 1;
		TMatrix<T> res(this->size);
		res.matrix = this->matrix - tmp.matrix;
		return res;
	}

	TMatrix operator* (const int k) {
		TMatrix<T> res(this->size);
		for (int i = 0; i < (this->size); i++) {
			res.matrix[i] = (this->matrix[i]) * k;
		}
		return res;
	}


	friend ostream & operator <<(ostream & out, TMatrix<T> & tmp) {
		for (int i = 0; i < tmp.size; i++) {
			for (int j = 0; j < tmp.size; j++) {
				if (j >= i) {
					out << tmp[i][j] << ' ';
				}
				else out << "0 ";
			}
			out << '\n';
		}
		return out;
	}
	friend istream & operator >>(istream &in, TMatrix<T> &tmp) {
		for (int i = 0; i < tmp.size; i++) {
			for (int j = 0; j < tmp.size; j++) {
				if (j >= i) {
					in >> tmp[i][j];
				}
				else {
					int x;
					in >> x;
				}
			}
		}
		return in;
	}
};

