
#include <string>
#include <iostream>

using namespace std;
int main()
{
	int k, n;
	string *name, *best;
	setlocale(0, "");
	cout << "���-�� �� " << endl;
	cin >> n;
	name = new string[n];
	cout << "����� ������ " << endl;
	for (int i = 0; i < n; i++) {
		cin >> name[i];
	}
	k = 0;
	best = new string[n];
	for (int i = 0; i < n; i++) {
		if (name[i].find("a")==0)
		{
			best[k++] = name[i];
		}
		
	}
	cout << "������ ������� " <<endl;
	for (int i = 0; i < n; i++) 
	{
		cout << best[i] << endl;
	}
	system("pause");
	return 0;
}