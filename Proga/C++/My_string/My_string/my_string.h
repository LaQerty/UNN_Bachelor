#pragma once
#include<string>
#include<iostream>
#include<conio.h>
using namespace std;
class my_string
{
private:
	char *mem;
	int size;
	int count;
public:
	//1
	my_string(int _size = 80) {
		size = _size;
		mem = new char[size];
		for (int i = 0; i < size; i++) {
			mem[i] = ' ';
		}
		count = 0;
	}
	
	//3
	~my_string() {
		delete[]mem;
	}
	//2
	my_string(const my_string&tmp) {
		size = tmp.size;
		count = tmp.count;
		mem = new char[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
	}
	//4
	my_string(const string&tmp) {
		size = tmp.length() + 2;
		count = tmp.length();
		mem = new char[size];
		for (int i = 0; i < count; i++) {
			mem[i] = tmp[i];
		}
		mem[count] = ' ';
		mem[count + 1] = ' ';
	}
	//5
	my_string&operator=(my_string tmp) {
		if (size != tmp.size) {
			if (size != 0) {
				delete[]mem;
			}
			size = tmp.size;
			mem = new char[size];
		}
		count = tmp.count;
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
		return *this;
	}
	//6
	my_string&operator=(const string tmp) {
		for (count = 0; (count < size) && (count < tmp.length()); count++) {
			mem[count] = tmp[count];
		}
		for (int i = count; i < size; i++) {
			mem[i] = ' ';
		}
		return *this;
	}
	//7
	friend ostream&operator<<(ostream &out, my_string tmp) 
	{
		for(int i = 0; i < tmp.count; i++) {
			out << tmp.mem[i];
		}
		return out;
	}
	//8 
	friend istream&operator>>(istream &in, my_string &tmp) {
		char c;
		do {
			c=in.get();//cin>>c;
			if (c!='\n') 
			{
				tmp.mem[tmp.count++] = c;
		    }
		} while (c!= '\n');
		return in;
	}
	//9
	char&operator[](int ind) {
		char f = ' ';
		if ((ind >= 0) && (ind < count)) {
			return mem[ind];
		}
		else return f;
	}
	//10
	int&operator==(my_string tmp) {
		int ans = 1;//строки равны
		if (count != tmp.count) {
			ans = 0;//неравные строки
		}
		else
		{
			for (int i = 0; i < tmp.count; i++) {
				if (mem[i] != tmp.mem[i]) {
					ans = 0;
				}
			}
		}
		return ans;
	}
	//11
	int&operator>(my_string tmp) {
		int i, ans = 1;//mem>tmp
		for (i = 0; (i < count) && (i < tmp.count) && (mem[i] == tmp.mem[i]); i++);
		if ((i < count) && (i < tmp.count) && (mem[i] < tmp.mem[i])) ans = 0;//mem<tmp
		return ans;
	}
	//12
	int&operator<(my_string tmp) {
		int i, ans = 1;//mem<tmp
		for (i = 0; (i < count) && (i < tmp.count) && (mem[i] == tmp.mem[i]); i++);
		if ((i < count) && (i < tmp.count) && (mem[i] > tmp.mem[i])) ans = 0;//mem>tmp
		return ans;
	}
	//13
	my_string operator+(my_string tmp) {
		my_string res;
		res.size = size + tmp.size;
		res.count = count + tmp.count;
		res.mem = new char[res.size];
		for (int i = 0; i < count; i++) {
			res.mem[i] = mem[i];
		}
		for (int i = 0; i < tmp.count; i++) {
			res.mem[i + count] = tmp.mem[i];
		}
			for (int i = res.count; i < res.size; i++) {
			res.mem[i] = ' ';
		}
		return res;
	}
	//14 
	my_string operator+(const string tmp) {
		my_string res;
		my_string param(tmp);
		res = (*this) + param;
		return res;
	}
	//15
	my_string operator+(const char tmp) {
		char ch = tmp;
		string str{ ch };
		my_string res;
		my_string param(str);
		res = (*this) + param;
		return res;
	}
	//16 
	my_string copy(int k, int n) {
		my_string res;
		if (res.size < n) {
			res = my_string(size);
		}
		res.count = res.size;
			for (int i = 0; i < n; i++) {
				res.mem[i] = mem[i + k];
			}
			for (int i = n; i < res.size; i++) {
				res.mem[i] = ' ';
			}
		return res;
	}
	//17
	void del(int k, int n) {
		if ((k + n) < count) {
			for (int i = 0; (i < n) && ((i + k + n) < count); i++) {
				mem[i + k] = mem[i + k + n];
			}
		}
		count -= n;
		for (int i = count; i < size; i++) {
			mem[i] = ' ';
		}
	}
	//18
	int find(my_string tmp, int k = 0) {
		int l = -1;
		for (int i = 0; (i < count - tmp.count) && (l == -1); i++) {
			if (mem[i] == tmp.mem[0]) {
				int j;
				for (j = 0; (j < tmp.count) && (mem[i + j] == tmp.mem[j]); j++);
				if (j == tmp.count) {
					l = i;
				}
				if (l < k) {
					l = -1;
				}
			}
		}
		return l;
	}
	//19
	int len() {
		return count;
	}
	//20
	int my_stringToInt() {
		int res = 0, l = 0;
		for (int i = 0; i < count; i++)
		{
			if ((mem[i] >= '0') && (mem[i] <= '9'))
			{
				l = mem[i] - 48;
				res = res * 10 + l;
			}
			else {
				res = 0; break;
			}
			
		}
		return res;
	}
	//21
	my_string IntToMy_string(int n) {
		my_string res;
		int k = n, l = 0;
		res.count = 0;
		while (k > 0) {
			k = k / 10;
			res.count++;
		}
		if (res.count > res.size) {
			res = my_string(res.count + 2);
		}
		k = n; l = 0;
		for (int i = res.count - 1; i >= 0; i--) {
			l = k % 10;
			k = k / 10;
			res.mem[i] = l + 48;
		}
		(*this) = res;
		return (*this);
	}
};

