#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>
#include <string.h>

using namespace std;
int main() {
	int l, k, len;
	string st;
	string zn;
	string *w;
	setlocale(LC_ALL, "Rus");
	cout<<"Введите строку: "<<endl;
	getline(cin, st);
	cout<<"Знаки: "<<endl;
	getline(cin, zn);
	k = 0;
	w =new string[st.length() + 1];
	w[0] = "";
	st += " ";
	for (int i = 0; i < st.length(); i++)
	{
		l = zn.find(st[i]);
		if (!((l>=0)&&(l<zn.length())))
		{
		w[k]+= st[i];
		}
		else
		{ 
			if (st[i] == ' ') 
		{
			if (w[k] != "")
			{
				w[++k] = "";
			}
		}
		else
			{
				if (w[k] != "")
				{
					w[++k] = st[i];
				}
				else
				{ 
					w[k] = st[i];
				}

				w[++k] ="";

			}
		}
	}
	cout<<"Слова: "<<endl;
	for (int i = 0; i < k; i++) {
		cout<< w[i]<<endl;
	}
	system("pause");
	return 0;
}