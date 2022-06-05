#pragma once
#include<string>
#include<iostream>
//#include"Header.h"
//#include"Header1.h"
//#include"Header2.h"
template <class T>
class Stack
{
private:
	int size;
	T *mem;
	int last;
public:
	Stack(int _size = 0) {
		size = _size;
		last = 0;
		mem = new T[size];
		for (int i = 0; i < size; i++) {
			mem[i] = T();
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
			return mem[last - 1];
		}
		else throw - 1;
	}
	T pop() {
		if (last > 0) {
			return mem[--last];
		}
		else throw - 1;
	}
	int IsEmpty() {
		if (last == 0) { return 1; }//пустой	
		else return 0;
	}
	int IsFull() {
		if (last < (size - 1)) return 0;//не полон
		else return 1;//полон
	}
};

template <class T>
class Line
{
private:
	T value;
	std::string name;
public:
	Line<T>(std::string _name = "", T _value = 0) {
		name = _name;
		value = _value;
	}
	~Line() {};
	std::string getN() {
		return name;
	}
	T getV() {
		return value;
	}
	void setV(T tmp) {
		value = tmp;
	}
};



template <class T>
class Table
{
private:
	Line < T > *mem;
	int size, count;
public:
	Table<T>(int _size = 0) {
		size = _size;
		count = 0;
		mem = new Line<T>[size+1];
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
	int search_line(std::string name) {
		int k = -1, i = 0;
		while ((i < count) && (k == -1)) {
			if (name == mem[i].getN()) k = i;
			i++;
		}
		return k;
	}
	T search(std::string name) {
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
	void del(std::string name) {
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
	T GetV(std::string name) {
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


class cPoliz
{
private:
	std::string *poliz;
	int size_pol;
	int count_pol;
	Table<double>* tab_per;
	Table<int>* tab_prior;
	Stack<Line<int>> stack_prior;

	void DivingLineWithOther(std::string st, std::string *w, int &k) {
		std::string zn = "+-*/^() ";
		int i, l;
		st += " ";
		for (i = 0; i < st.length(); i++) {
			l = zn.find(st[i]);
			if (!((l >= 0) && (l < zn.length()))) {
				w[k] += st[i];
			}
			else {
				if (st[i] == ' ') {
					if (w[k] != "") {
						//w[++k] = ""; 
					}
				}
				else {
					if (w[k] != "") {
						w[++k] = st[i];
					}
					else {
						w[k] = st[i];
					}
					w[++k] = "";
				}
			}
		}
	}

	void made_tab_prior() {
		tab_prior = new Table<int>(6);
		tab_prior->push(Line<int>("+", 1));
		tab_prior->push(Line<int>("-", 1));
		tab_prior->push(Line<int>("*", 2));
		tab_prior->push(Line<int>("/", 2));
		tab_prior->push(Line<int>("^", 3));
		// tab_prior->push(Line<int>("(", 3));
		 //tab_prior->push(Line<int>(")", 3));
	}
	void left_brecket() {
		if (!stack_prior.IsFull()) {
			stack_prior.push(Line<int>("("));
		}
	}
	void right_brecket() {
		while (!stack_prior.IsEmpty() && stack_prior.top().getN() != "(")
		{
			poliz[count_pol++] = stack_prior.pop().getN();
		}
		stack_prior.pop();
	}
	void operand(std::string op) {
		poliz[count_pol++] = op;
		int bool_ = 1;
		for (int i = 0; i < tab_per->getCount() && bool_; i++) {
			if (tab_per->search_line(op) != -1) {
				bool_ = 0;
			}
		}
		if (bool_) {
			if (int(op[0]) > 48 && int(op[0]) < 58) {
				tab_per->push(Line<double>(op, double(stoi(op))));
			}
			else {
				tab_per->push(Line<double>(op));
			}
		}
	}
	void operation(Line<int> tmp) {
		while ((stack_prior.IsEmpty() != 1) && (stack_prior.top().getV() >= tmp.getV())) {
			poliz[count_pol++] = stack_prior.pop().getN();
		}
		stack_prior.push(tmp);
	}
	void end_of() {
		while (stack_prior.IsEmpty() != 1) {
			poliz[count_pol++] = stack_prior.pop().getN();
		}
	}
	void made_tbl_of_per(double *tmp) {
		for (int i = 0; i < tab_per->getCount(); i++) {
			if (!(*(tab_per))[i].getV() && (*(tab_per))[i].getN() != "0") {
				tab_per->set_value(i, tmp[i]);
			}
		}
	}
	void made_poliz(std::string tmp, double*mp) {
		std::string zn = "+-*/^() ";
		std::string *w = new std::string[tmp.length()];
		int k = 0;
		DivingLineWithOther(tmp, w, k);
		count_pol = 0;
		for (int i = 0; i <= k; i++) {
			int tmp = zn.find(w[i]);
			if (tmp >= 0) {
				if (w[i] == "(") {
					left_brecket();
				}
				else if (w[i] == ")") {
					right_brecket();
				}
				else if (w[i] != "") {
					operation(Line<int>(w[i], tab_prior->GetV(w[i])));
				}

			}
			else operand(w[i]);
		}
		end_of();
		made_tbl_of_per(mp);
		
	}
public:
	cPoliz(std::string str = "", double *pm=0) {
		size_pol = str.length() + 1;
		str += " ";
		poliz = new std::string[size_pol];
		count_pol = 0;
		made_tab_prior();
		tab_per = new Table<double>(size_pol / 2 + 1);
		stack_prior = Stack<Line<int>>(size_pol / 2 + 1);
		//if (size != 1) {
		made_poliz(str, pm);
		//}
	}
	~cPoliz() {
		delete[]poliz;
		//		delete[]tab_per;
	}
	cPoliz(const cPoliz &tmp) {
		size_pol = tmp.size_pol;
		poliz = new std::string[size_pol];
		count_pol = tmp.count_pol;
		made_tab_prior();
		tab_per = new Table<double>(size_pol / 2);
		(*tab_per) = (*(tmp.tab_per));
		stack_prior = Stack<Line<int>>(size_pol / 2);
		for (int i = 0; i < count_pol; i++) {
			poliz[i] = tmp.poliz[i];
		}
	}
	cPoliz&operator=(const cPoliz&tmp) {
		if (size_pol != tmp.size_pol) {
			if (size_pol != 0) {
				delete[]poliz;
			}
			size_pol = tmp.size_pol;
			poliz = new std::string[size_pol];
		}
		count_pol = tmp.count_pol;
		for (int i = 0; i < count_pol; i++)
		{
			poliz[i] = tmp.poliz[i];
		}
		made_tab_prior();
		if (tab_per->getCount()) {
			delete[]tab_per;
		}
		tab_per = new Table<double>(size_pol);
		(*tab_per) = (*(tmp.tab_per));
		stack_prior = Stack<Line<int>>(size_pol / 2);
		return *this;
	}
	std::string get_pol() {
		std::string res = "";
		for (int i = 0; i < count_pol; i++) {
			res += poliz[i] + " ";
		}
		return res;
	}
	std::string operator[](int k) {
		if ((k >= 0) && (k < count_pol)) {
			return poliz[k];
		}
		else return "";
	}
	int get_count_pol() {
		return count_pol;
	}
	Table<double>* get_table_operand() {
		return tab_per;
	}

};


class ARRV
{
private:
	std::string str;
	cPoliz tmp;
	Stack <double > stack;
public:
	ARRV(std::string _str="", double *pm=0) {
		if (_str[_str.length() - 1] == ')') {
			_str += "+0";
		}
		//str = _str;
		tmp = *new cPoliz(_str, pm);
		stack = *(new Stack<double>(_str.length()));
	}
	ARRV(const ARRV&_tmp) {
		str = _tmp.str;
		tmp = _tmp.tmp;
	}
	//ARRV&operator =(const ARRV&_tmp) {
	//	str = _tmp.str;
	//	//delete tmp;
	//	tmp = _tmp.tmp;
	//	return *this;
	//}
	~ARRV() {}
	double calculate() {
		Stack<double> st(tmp.get_count_pol());
		double left, right;
		for (int i = 0; i < tmp.get_count_pol(); i++) {
			int k = tmp.get_table_operand()->search_line(tmp[i]);
			if (k != -1) {
				st.push(tmp.get_table_operand()->GetV(tmp[i]));
			}
			else {
				right = st.pop();
				left = st.pop();
				if (tmp[i] == "+")st.push(left + right);
				else if (tmp[i] == "-")st.push(left - right);
				else if (tmp[i] == "*")st.push(left*right);
				else if (tmp[i] == "/")st.push(left / right);
				else if (tmp[i] == "^")st.push(pow(left, right));
			}
		}
		return st.pop();
	}
	cPoliz getPoliz() {
		return tmp;
	}
};

