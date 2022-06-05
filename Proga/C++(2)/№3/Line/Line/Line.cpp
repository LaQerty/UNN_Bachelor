#include "Line.h"
#include <iostream>
#include<string>
using namespace std;
int main() {
	Line<int> a("asdsdas",10);
	int b = a.getV();
	string c = a.getN();
	cout << "value=" << b << endl;
	cout << "name=" << c << endl;
	a.setV(1);
	b = a.getV();
	cout << "value2=" << b << endl;
	system("pause");
}

