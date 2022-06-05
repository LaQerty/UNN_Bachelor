#define _CRT_SECURE_NO_WARNINGS
#include<stdlib.h> 
#include<stdio.h> 
#include<locale.h> 
#include<string> 
#include<Windows.h> 
#include<iostream>
using namespace std;
int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	int n, m, len;
	string *tk;
	string last;
	string *line;
	cout<<"¬ведите количество строк "<<endl;
	cin>>n;
	tk = new string[n*10000];
	line = new string[1000 * n];
	last+='.!?';
    cout<<"¬ведите текст Ч "<<endl;
	for (int i = 0; i < n; i++) {
		cin >> tk[i];
	}
	m = 0;
	line[m] = "";
	for (int i = 0; i < n; i++)
	{
		tk[i] += " ";
		for (int j = 0; j < tk[i].length(); j++)
		{
			if (last.find(tk[i][j]) ==-1)
			{
				line[m] += tk[i][j];
			}
			else {
				line[m++] += tk[i][j];
			}
		}
	}
	cout<<"ѕреобразованный список"<<endl;
	for (int i = 0; i <=m; i++) {
		cout<< line[i]<<endl;
	}
	system("pause");
	return 0;
}