#include<iostream>
#include<stdio.h>
using namespace std;
int main() {
	int *a, n, min, l;
	setlocale(0, "");
	cout << "������� ���-�� �����" << endl;
	cin >> n;
	a = new int[n];
	cout << "������� �����" << endl;
	for (int i = 0; i < n; i++) {
		cin >> a[i];

	}
	min = a[0];
	l = 0;
	for (int i = 0; i < n; i++) {
		if (a[i] < min) {
			min = a[i];
			l = i;

		}
	}
	cout << "Min= " << min<< endl<< "����� - " << l<<endl;
	system("pause");
	return 0;
}