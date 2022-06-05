#include"complex.h"
#include<iostream>
#include<math.h>
using namespace std;
int main() {
	complex c;
	complex b(4, 2);
	complex t(10, 15);
	complex x;
	complex a(t);
	complex a1, a2, a3, a4;
	cout << "t.Re=" << t.getRe() << endl;
	cout << "t.Im=" << t.getIm() << endl;
	cout << "t.modul=" << t.getmodul() << endl;
	x.setRe(35);
	x.setIm(-4);
	cout << "x.Re=" << x.getRe() << endl;
	cout << "x.Im=" << x.getIm() << endl;
	cout << "x.modul=" << x.getmodul() << endl;
	a1 = t + x;
	cout << "a1.Re=" << a1.getRe() << endl;
	cout << "a1.Im=" << a1.getIm() << endl;
	cout << "a1.modul=" << a1.getmodul() << endl;
	a2 = t - x;
	cout << "a2.Re=" << a2.getRe() << endl;
	cout << "a2.Im=" << a2.getIm() << endl;
	cout << "a2.modul=" << a2.getmodul() << endl;
	a3 = t * x;
	cout << "a3Re=" << a3.getRe() << endl;
	cout << "a3.Im=" << a3.getIm() << endl;
	cout << "a3.modul=" << a3.getmodul() << endl;
	a4 = t / x;
	cout << "a4.Re=" << a4.getRe() << endl;
	cout << "a4.Im=" << a4.getIm() << endl;
	cout << "a4.modul=" << a4.getmodul() << endl;
	cout << b << endl;
	for (int i = 0; i < 5; i++) {
		cout << "Vvedi chislo" << endl;
		cin >> c;
		cout << c << endl;
		a1 = t * c;
		cout << a1 << endl;
			a1=t/ c;
			cout << a1 << endl;
			system("pause");
	}
	system("pause");
}