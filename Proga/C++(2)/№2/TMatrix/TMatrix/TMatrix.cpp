#include "TMatrix.h"
#include"Header.h"
int main() {
	int n,k;
	cout << "Vvedi kolvo" << endl;
	cin >> n;
	TMatrix<int> a(n),c(a);
	TMatrix<int> b(a);
	cout << "Vvedi a" << endl;
	cin >> a;
	cout << "a=\n" << a << endl;
	cout << "Vvedi b" << endl;
	cin >> b;
	cout << "b=\n" << b << endl;
	c = a;
	cout << "c=\n" << c << endl;
	c = a * b;
	cout << "a*b=\n" << c << endl;
	c = a + b;
	cout << "a+b=\n" << c << endl;
	c = a - b;
	cout << "a-b=\n" << c << endl;
	a[1][1] = 5;
	cout << "a=\n" << a << endl;

	system("pause");
}