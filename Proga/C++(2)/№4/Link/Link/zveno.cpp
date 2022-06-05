#include "zveno.h"
#include<iostream>
using namespace std;
int main() {
	int k = 1;
	zveno a(12);
	zveno b;
	zveno *c;
	link z;
	link x(z);
	b = a;
	cout << b.get_info() << endl;
	b.set_info(k);
	cout << b.get_info() << endl;
	/*c = b.get_next();
	cout << c->get_info << endl;
	b.set_next(c);*/

	for (int i = 0; i < 3; i++) {
		z.push(k);
	}
	z.print();
	system("pause");
}
