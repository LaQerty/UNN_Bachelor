#pragma once
template <class T> 
class Stack
{private:
	int size;
	T *mem;
	int last;
public:
	Stack(int _size = 0) {
		size = _size;
		last = 0;
		mem = new T[size];
		for (int i = 0; i < size; i++) {
			mem[i] = 0;
		}
	};
	Stack<T>(const Stack<T> &tmp) {
		size = tmp.size;
		last = tmp.last;
		mem = new T[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}

	};
	Stack<T> &operator=(const Stack<T>&tmp) {
		if (size != tmp.size) {
			if (size) {
				delete[]mem;
			}
			size = tmp.size;
			mem = new T[size];
			 }
		last = tmp.last;
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
		return *this;
	}
	~Stack() {
		delete[]mem;
	}
	void push(T tmp) {
		if (last < size) {
			mem[last++] = tmp;
		}
	}
	T top() {
		if (last > 0) {
			return mem[size - 1];
		}
		else throw - 1;
	}
	T pop() {
		if (last > 0) {
			return mem[--last];
		}
		else throw - 1;
	}
	int IsEmpty(){
		if (last == 0) { return 1; }//пустой	
		else return 0;
	}
	int IsFull() {
		if (last < (size - 1)) return 0;//не полон
		else return 1;//полон
	}
};

