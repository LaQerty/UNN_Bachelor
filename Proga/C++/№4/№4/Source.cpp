#include<cstring> 
#include<iostream>
#include<string> 
using namespace std;
int main() {
	setlocale(0, "");
	int n,l,i;
	string *name, ctrl, tmp;
	cout << "������� ���-�� ��������� " << endl;
	cin >> n;
	cout << "������� ������ " << endl;
	name = new string[n];
	for (int i = 0; i < n; i++)
	{
		cin>>tmp;
		name[i]=tmp;
	}
	cout << "������� ������� " << endl;
	cin >> ctrl;
	l = -1;
	i = 0;
	while ((l == -1) && (i < n))
	{
		if (name[i]==ctrl)
		{
			l = i;
		}
		i++;
	}
	cout<<"������ ��� �������"<< l<<endl;
	system("pause");
	return 0;
}