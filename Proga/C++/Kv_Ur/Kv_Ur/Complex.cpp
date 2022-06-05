#include "Complex.h"
#include "Complex.h"
#pragma once
#include<ostream>
#include<istream>
#include<iostream>
#include<string>
using namespace std;
void DivingLineWithOther(string st, string *w, int &k, string zn) {
	st = st + " ";
	k = 0;
	w[0] = "";
	for (int i = 0; i < st.length(); i++) {
		if (zn.find(st[i]) == -1) {
			w[k] += st[i];
		}
		else
		{
			if (st[i] == ' ')
			{
				if (w[k].length() != 0)
				{
					w[++k] = "";
				}

			}
			else
			{
				if (w[k].length() != 0)
				{
					w[++k] = st[i];
				}
				else w[k] = st[i];
			}
		}
	}
};

Complex::Complex(int re, int im) {
	Re = re;
	Im = im;
	m = getm();
};
Complex::Complex() {
	Re = 0;
	Im = 0;
	m = 0;
}

Complex:: ~Complex() { /*cout << "Вызван диструктор" << endl; */ };


int Complex::getRe() {
	return Re;
};
int Complex::getIm() {
	return Im;
};
int Complex::getmod() {
	return m;
};
void Complex::setRe(int _re) {
	Re = _re;
};
void Complex::setIm(int _im) {
	Im = _im;
};
Complex::Complex(const Complex &a) {
	Re = a.Re;
	Im = a.Im;
	m = a.m;
	//cout << "Вызван конструктор копирования" << endl;
};
Complex &Complex:: operator= (Complex a) {
	Re = a.Re;
	Im = a.Im;
	m = a.m;
	//cout << "Вызван оператор присванивания" << endl;
	return *this;
};
/*Complex &Complex:: operator= (int a) {
	Re = a;
	Im = 0;
	m = a;
	//cout << "Вызван оператор присванивания" << endl;
	return *this;
};*/
Complex Complex:: operator+ (Complex t) {
	Complex res;
	res.Re = Re + t.Re;
	res.Im = Im + t.Im;
	res.m = res.getm();
	return res;
};
Complex Complex:: operator- (Complex t) {
	Complex res;
	res.Re = Re - t.Re;
	res.Im = Im - t.Im;
	res.m = res.getm();
	return res;
};
Complex Complex:: operator/ (Complex tmp) {
	int del = tmp.Re*tmp.Re + tmp.Im*tmp.Im;
	Complex res;
	res.Re = (Re*tmp.Re + Im * tmp.Im) / del;
	res.Im = (Im*tmp.Re - tmp.Im*Re) / del;
	res.m = res.getm();
	return res;
};
Complex Complex:: operator* (Complex tmp) {
	Complex res;
	res.Re = Re * tmp.Re - Im * tmp.Im;
	res.Im = Re * tmp.Im + Im * tmp.Re;
	res.m = res.getm();
	return res;
};
std::ostream &operator<< (std::ostream &out, const Complex a) {
	out << a.Re;
	if (a.Im >= 0) {
		out << "+" << a.Im << "i";;
	}
	else out << a.Im << "i";
	return out;
};
std::istream &operator>>(std::istream &in, Complex &a) {
	string str = "";
	in >> str;
	string *w;
	w = new string[4];
	int k;
	DivingLineWithOther(str, w, k, "+- ");
	//	system("pause");
	a.Re = 0;
	a.Im = 0;
	for (int i = 0; i < k; i++)
	{
		int pos = w[i].find("i");
		if ((pos >= 0) && (pos < w[i].length()))
		{
			w[i].erase(pos, 1);
			if (w[i].length() == 0 || w[i] == "+" || w[i] == "-") {
				w[i] += "1";
			}
			a.Im = atoi(w[i].c_str());
		}
		else
		{
			if (w[i] == "+" || w[i] == "-")
			{
				w[i] += "1";
			}
			a.Re = atoi(w[i].c_str());
		}
	}
	a.m = a.getm();
	/*cout << a.Re << "   " << a.Im << "i" << endl;*/
	return in;
};
