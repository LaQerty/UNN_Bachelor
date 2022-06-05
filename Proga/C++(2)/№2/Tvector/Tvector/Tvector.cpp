#include "Tvector.h"
#include<iostream>

using namespace std;
int main() {
	int n;
	cout << "Size a and b" << endl;
	cin >> n;
	Tvector<int> a(n), b(n);
	Tvector<int> c(a),d;
	cout << "Enter a" << endl;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	cout << "Enter b" << endl;
	for (int i = 0; i < n; i++) {
		cin >> b[i];
	}
	cout << "a=" << a << endl;
	cout << "b=" << b << endl;
	c = a;
	d = b;
	cout << "d=" << d << endl;
	cout << "c=" << c << endl;
	cout << "a + b=" << a + b << endl;
	cout<<"a - b="<<a-b<<endl;
	cout << " a * b=" << a * b<< endl;
	 system("pause");
 }

