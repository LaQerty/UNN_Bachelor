
#include <iostream>
#include"Urav.h"
#include"Complex.h"
int main()
{
	setlocale(LC_ALL, "Rus");
	int a, b, c;
	for (int i = 0; i < 3; i++) {
		cout << "����� ������������ " << endl;
		cin >> a >> b >> c;
		kv_ur d(a, b, c);
		Complex x1, x2;
		double res = d.answer(x1, x2);

		if (res == -1) cout << "��� ������ " << endl;
		else if (res == -2) cout << "���������� ������" << endl;
		else cout << "����� ���������: " << x1 << " " << x2 << endl;
		system("pause");
	}
	return 0;
}