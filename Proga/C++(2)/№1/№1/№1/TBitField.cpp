#include "TBitField.h"
#include "string"
#include"iostream"

using namespace std;
int main() {
	string v;
	int q, w, e, u=100;
	TBitField a, d(u),t,z;
	TBitField b(u),x(u);
	TBitField c;
	b.add(110);
	b.add(1);
	v= b.TBitField_ToString(u);
	cout << "b="<< v<< endl;
	c = b;
	c.add(9);
	v = c.TBitField_ToString(u);
	cout << "c=" << v << endl;
	c.Del(1);
	v = c.TBitField_ToString(u);
	cout << "c=" << v << endl;
	a = u;
	a.add(44);
	d = a + c;
	v = d.TBitField_ToString(u);
	cout << "d=" << v << endl;
	z = ~a;
	v = z.TBitField_ToString(u);
	cout << "z=" << v << endl;
	x.add(44);
	x.add(55);
	t = a ^ x;
	v = t.TBitField_ToString(u);
	cout << "t=" << v << endl;
	system("pause");
}
