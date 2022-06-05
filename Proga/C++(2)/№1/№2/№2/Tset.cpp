#include "Tset.h"
#include "string"
#include"iostream"

using namespace std;
int main() {
	string v;
	int q, w, e,u=100;
	TSet a(u), d, t, z;
	TSet b(u), x(u);
	TSet c(a);
	TSet ab(u,"1 2 3 4 5");
	v = ab.TSet_ToStr();
	cout << "ab=" << v << endl;
	b.add(100);
	b.add(111);
	v = b.TSet_ToStr();
	cout << "b=" << v << endl;
	c = b;
	c.add(9);
	v = c.TSet_ToStr();
	cout << "c=" << v << endl;
	c.del(100);
	v = c.TSet_ToStr();
	cout << "c=" << v << endl;
	a = 100;
	a.add(44);
	d = a + c;
	v = d.TSet_ToStr();
	cout << "d=" << v << endl;
	z = ~a;
	v = z.TSet_ToStr();
	cout << "z=" << v << endl;
	x.add(44);
	x.add(55);
	t = 100;
	t = a ^ x;
	v = t.TSet_ToStr();
	cout << "t=" << v << endl;
	system("pause");
}



