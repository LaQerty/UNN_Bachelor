#include<cstring> 
#include<iostream>
#include<string>
using namespace std;
int main() {
	setlocale(0, "");
	
		int n,s,f,L;
		string *name,ctrl;
		cout << "���-�� ��������� " << endl;
		cin >> n;
		name = new string[n];
		cout<<"������� ������"<<endl;
		for (int i = 0; i < n; i++)
		{
			cin>>name[i];
		}

		cout << "������� :" << endl;  
		cin>> ctrl;

		s = 0;
		f = n - 1;
		L = -1;
		while ((L == -1) && (s <= f))
		{
			int midle = (s + f) / 2;
			if (name[midle] < ctrl)
				s = midle + 1;
			if (name[midle] == ctrl)
				L = midle;
			if (name[midle] > ctrl)
				f = midle - 1;
		}

		cout << "������ ��� �������: " << L << endl;

		system("Pause");
		return 0;
	}

