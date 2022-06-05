#pragma once
#include<ostream>
#include<istream>
#include<iostream>
#include<string>
using namespace std;
void DivingLineWithOther(string st, string *w, int &k, string zn);
class Complex
{
private:
	int Re;
	int Im;
	double m;
	double getm() {
		return (sqrt(Im*Im + Re * Re));
	}
public:
	~Complex();
	Complex(int re, int im);
	Complex();
	int getRe();
	int getIm();
	int getmod();
	void setRe(int _re);
	void setIm(int _im);
	Complex(const Complex &a);
	Complex &operator= (Complex a);
	Complex operator+ (Complex t);
	Complex operator- (Complex t);
	Complex operator/ (Complex tmp);
	Complex operator* (Complex tmp);
	friend std::ostream &operator<< (std::ostream &out, const Complex a);
	friend std::istream &operator>>(std::istream &in, Complex &a);
};

