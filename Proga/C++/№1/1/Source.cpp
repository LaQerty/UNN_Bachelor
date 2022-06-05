
#include <stdio.h>
#include <iostream>

using namespace std;
int main()
{
	int *a, sum, n;
	cout << "Kol-vo chisel" << endl;
	cin >> n;
	a = new int[n];
	cout << "Vvedi chisla" << endl;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sum = 0;
	for (int i = 0; i < n; i++) {
		sum += a[i];

	}
	cout << "Sum =" << sum;
	system("pause");
	return 0;
}