#include<cstring> 
#include<iostream>
#include<string> 
using namespace std;
int main() {
	setlocale(0, "");
	int n,l,i;
	string *name, ctrl, tmp;
	cout << "Введите кол-во элементов " << endl;
	cin >> n;
	cout << "Введите список " << endl;
	name = new string[n];
	for (int i = 0; i < n; i++)
	{
		cin>>tmp;
		name[i]=tmp;
	}
	cout << "Введите искомое " << endl;
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
	cout<<"Найден под номером"<< l<<endl;
	system("pause");
	return 0;
}