#pragma once
#include"Header1.h"
template <class T>
class Table
{
private:
	Line < T > *mem;
	int size, count;
public:
	Table<T>(int _size = 0) {
		size = _size;
		mem = new Line<T>[size];
		for (int i = 0; i < size; i++) {
			mem[i] = Line<T>("");
		}
	}
	Table<T>(const Table<T>&tmp) {
		size = tmp.size;
		mem = new Line<T>[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
	}
	~Table() {
		//		delete[]mem;
	}
	Table<T>&operator=(const Table<T>&tmp) {
		if (size != tmp.size) {
			if (size) {
				delete[]mem;
			}
			size = tmp.size;
		}
		count = tmp.count;
		mem = new Line<T>[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
		return *this;
	}
	int search_line(string name) {
		int k = -1, i = 0;
		while ((i < count) && (k == -1)) {
			if (name == mem[i].getN()) k = i;
			i++;
		}
		return k;
	}
	T search(string name) {
		int res = search_line(name);
		if (res != -1) {
			return mem[res].getV();
		}
		else return T(0);
	}
	void push(Line<T> tmp) {
		int l = search_line(tmp.getN());
		if (l == -1) {
			if (count < size) {
				mem[count++] = tmp;
			}
		}
		else mem[l] = tmp;
	}
	void del(string name) {
		int l = search_line(name);
		if (l != -1) {
			mem[l] = mem[--count];
		}
	}
	int IsEmpty() {
		if (count == 0) return 1; //Pusto
		else return 0;//ne pusto
	}
	int IsFull() {
		if (count == size) return 1;//Polna
		else return 0;//Ne Polna
	}
	Line<T> operator[](int k) {
		if ((k >= 0) && (k < count))return mem[k];
		else return Line<T>("", 0);
	}
	int getCount() {
		return count;
	}
	T GetV(string name) {
		int k = -1;
		for (int i = 0; i < count&&k == -1; i++) {
			if (mem[i].getN() == name) {
				k = i;
			}
		}
		if (k == -1) {
			throw - 1;
		}
		return mem[k].getV();
	}
	void set_value(int index, T value) {
		mem[index].setV(value);
	}
};

