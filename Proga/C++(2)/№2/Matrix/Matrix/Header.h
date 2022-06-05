#pragma once
#pragma once
#include "Header1.h"
#include<iostream>

template <class T>
class TMatrix
{
private:
	Tvector<Tvector<T>> matr;
	int size;
public:
	TMatrix<T>(int _size = 0) {
		this->size = _size;
		this->matr = Tvector<Tvector<T>>(this->size);
		for (int i = 0; i < this->size; i++) {
			matr[i] = Tvector<T>(this->size - i, i);
		}
	}

	TMatrix<T>(const TMatrix<T> &tmp) {
		this->size = tmp.size;
		this->matr = tmp.matr;
	}
	Tvector<T> &operator[] (const int k) {
		if ((k >= 0) && (k < size))
			return this->matr[k];
		else throw - 1;
	}
	TMatrix<T> operator* (TMatrix<T>&tmp) {
		if (tmp.size != this->size) throw - 1;
		TMatrix<T> res(this->size);
		for (int i = 0; i < this->size; i++) {
			for (int j = i; j < this->size; j++) {
				for (int k = i; k <= j; k++) {
					T m = tmp.matr[k][j];
					m *= this->matr[i][k];
					res[i][j] += m;
				}
			}
		}
		return res;
	}
	TMatrix<T> &operator=(const TMatrix<T>&tmp) {
		if (this->size != tmp.size) {
			if (this->size) {
				this->matr = Tvector<Tvector<T>>(0);
				this->matr = Tvector<Tvector<T>>(tmp.size);
			}
			this->size = tmp.size;
		}
		matr = tmp.matr;
		return(*this);
	}
	TMatrix<T> operator+(const TMatrix<T>&tmp) {
		if (this->size != tmp.size) {
			this->size = tmp.size;
		}
		TMatrix res(size);
		res.matr = this->matr + tmp.matr;
		return res;
	}
	TMatrix<T> operator-(const TMatrix<T>&tmp) {
		if (this->size != tmp.size) {
			this->size = tmp.size;
		}
		TMatrix res(size);
		res.matr = this->matr - tmp.matr;
		return res;
	}


	~TMatrix() {}

	/*std::friend ostream & operator <<(ostream & out, TMatrix<T> & tmp) {
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
	std::friend istream & operator >>(istream &in, TMatrix<T> &tmp) {
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
	}*/
};

