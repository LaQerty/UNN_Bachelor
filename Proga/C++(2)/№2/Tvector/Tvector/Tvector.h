#pragma once
#include<iostream>
#include<string>
using namespace std;
template <class T> 
class Tvector
{private:
	T*mem;
	int size;
	int start;
public:
	Tvector(int _size = 0, int _start = 0) {
		size = _size;
		start = _start;
		mem = new T[size];
		for (int i = 0; i < size; i++) {
			mem[i] = T(0);
		}
	};
	Tvector(Tvector<T>&tmp) {
		size = tmp.size;
		start = tmp.start;
		mem = new T[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
	};
	Tvector<T>&operator=(const Tvector<T>& tmp) {
		if (size != tmp.size) {
			if (size != 0) {
				delete[]mem;
			}
			size = tmp.size;
			mem = new T[size];
		}
		start = tmp.start;
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
		return(*this);
	}
	~Tvector<T>() {
		delete[]mem;
	};
	T& operator[](int k) {
		if (k < start) { return mem[0];}
		if (k > (size + start)) { return mem[INT_MAX]; }
		return mem[k - start];
	};
	Tvector<T> operator+(Tvector<T>tmp) {
		Tvector res(0);
		if (size != tmp.size) { return res; }
		res = tmp;
		for (int i = 0; i < size; i++) {
			res[i] = mem[i] + tmp[i];
		}
		return res;
	};
	Tvector<T> operator-(Tvector<T>tmp) {
		Tvector res(0);
		if (size != tmp.size) { return res; }
		res = tmp;
		for (int i = 0; i < size; i++) {
			res[i] = mem[i] - tmp[i];
		}
		return res;
	};
	T operator*(Tvector<T>tmp) {
		T res = 0;
		for (int i = 0; i < size; i++) {
			res += (mem[i] * tmp.mem[i]);
		}
		return res;
	};
	T operator*(T k) {
			for (int i = 0; i < size; i++) {
			mem[i] *= k;;
		}
		return (*this);
	};
	friend ostream&operator<<(ostream&out, const Tvector<T> &tmp) {
		for (int i = 0; i < tmp.size; i++) {
			out<< T(tmp.mem[i])<< ' ';
		}
		return out;
	}
};

