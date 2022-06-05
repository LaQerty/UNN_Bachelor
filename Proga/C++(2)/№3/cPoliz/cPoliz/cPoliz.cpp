#include "cPoliz.h"
#include<string>
#include<iostream>
using namespace std;
int main() {
	string n;
	cout << "Strochka:" << endl;
	cin >> n;
	cPoliz a(n);
	string res;
	cPoliz b(a);
	cPoliz c;

	int d;
	c = a;
	res = c.get_pol();
	cout << res << endl;
	cout << c[2] << endl;
	d = a.get_count_pol();
	cout << d << endl;

	system("pause");
	return 0;
}



