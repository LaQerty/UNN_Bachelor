#pragma once
#include"Complex.h"
#include<iostream>
#include<iomanip>
#include<cmath>
#include<Windows.h>
class kv_ur
{
private:
	double a;
	double b;
	double c;

public:
	kv_ur(double _a = 0, double _b = 0, double _c = 0) {
		a = _a;
		b = _b;
		c = _c;
	}
	~kv_ur() {};
	kv_ur(const kv_ur&kvur) {
		a = kvur.a;
		b = kvur.b;
		c = kvur.c;
	}
	kv_ur &operator= (const kv_ur&kvur) {
		a = kvur.a;
		b = kvur.b;
		c = kvur.c;
	}
	double answer(Complex&x1, Complex&x2) {
		if (a == 0) {
			if (b == 0) {
				if (c != 0)
				{
					return -1;	//нет корней
				}
				else {
					return -2;	//бесконечно корней
				}
			}
			else {
				x1 = Complex(-c / b, 0);
				x2 = x1;
			}
		}
		else {
			double D;
			D = b * b - (4 * a*c);
			if (D == 0) {
				x1 = x2 = Complex((-b / (2 * a)), 0);
			}
			else {
				if (D > 0) {
					x1 = Complex(((-b + sqrt(D)) / (2 * a)), 0);
					x2 = Complex(((-b - sqrt(D)) / (2 * a)), 0);
				}
				else {
					x1 = Complex((-b / (2 * a)), (sqrt(-D) / (2 * a)));
					x1 = Complex((-b / (2 * a)), (-sqrt(-D) / (2 * a)));
				}
			}
		}
	}
};

