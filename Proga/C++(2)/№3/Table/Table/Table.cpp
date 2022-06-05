#include "Table.h"
#include<iostream>

using namespace std;
int main() {
	int n;
	cout << "Size a" << endl;
	cin >> n;
	Table<int> a(n),b(a);
	Line<int> c("adqdq",10);
	a.push(c);
	a.push(Line<int>("asdasdasdasd",22));
	for (int i = 0; i <n; i++) {
		cout << "a=" << a[i].getN() << endl;
	}
	b = a;
	for (int i = 0; i < n; i++) {
		cout << "b=" << b[i].getN() << endl;
	}
	a.push(Line<int>("poisk", 1));
	for (int i = 0; i < n; i++) {
		cout << "a=" << a[i].getN() << endl;
	}
	cout << "naiden v :" << a.search_line("poisk") << endl;
	cout << "naiden value :" << a.search("poisk") << endl;
	a.del("poisk");
	for (int i = 0; i < n; i++) {
		cout << "a=" << a[i].getN() << endl;
	}
	cout << "IsEmpty :" << a.IsEmpty() << endl;
	cout << "IsFull :" << a.IsFull() << endl;
	a.push(Line<int>("poisk", 1));
	cout << "Count :" << a.getCount() << endl;
	system("pause");
}


