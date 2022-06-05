//#define _CRT_SECURE_NO_WARNINGS
#include <string>
#include<iostream>
#include <Windows.h>
#include<conio.h>
#include<locale.h>
#include"Header.h"
using namespace std;
int menu(string *punktname, int n)
{
	HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	int i, k;
	char code;
	SetConsoleTextAttribute(hConsole, (WORD)((15 << 4) | 0));
	k = 0;
	do
	{
		system("cls");
		for (i = 0; i < n; i++)
		{
			if (i == k)
			{
				SetConsoleTextAttribute(hConsole, (WORD)((0 << 4) | 15));
				cout << punktname[i] << endl;
				SetConsoleTextAttribute(hConsole, (WORD)((15 << 4) | 0));
			}
			else { cout << punktname[i] << endl; }
		}
		code = _getch();
		if (code == 0)
		{
			code = _getch();
		}
		if (code == 72)//up
		{
			k--;
			if (k < 0) { k = n - 1; }
		}
		if (code == 80)//down
		{
			k++;
			if (k >= n) { k = 0; }
		}
	} while (code != 13);//enter
	return k;
}
int main()
{
	setlocale(0, "");
	string *punktname;
	int pos;
	int n = 10;
	punktname = new string[n];
	punktname[0] = "�����";
	punktname[1] = "�����";
	punktname[2] = "�����������";
	punktname[3] = "������ �";
	punktname[4] = "�������� �����";
	punktname[5] = "�������� �����";
	punktname[6] = "������ ��� ����������, �������, �����";
	punktname[7] = "���� �����������";
	punktname[8] = "��������� ������������";
	punktname[9] = "����� � �����������";
	do
	{
		pos = menu(punktname,n);
		switch (pos)
		{
		case 0: return 0; break;  //exit
		case 1: {
			int *a, n;
			setlocale(0, "");
			cout << "���-�� �����" << endl;
			cin >> n;
			a = new int[n];
			cout << "����� �����" << endl;
			for (int i = 0; i < n; i++) {
				cin >> a[i];
			}
			int sum = summing(a, n);
			cout << "Sum =" << sum << endl;
			system("pause");
		}
				break;
		case 2: {
			int *a, n,min=0,l=0;
			setlocale(0, "");
			cout << "������� ���-�� �����" << endl;
			cin >> n;
			a = new int[n];
			cout << "������� �����" << endl;
			for (int i = 0; i < n; i++)
			{
				cin >> a[i];
			}
			minimum(a, n, min, l);
			cout << "Min= " << min << endl << "����� - " << l << endl;
			system("pause");
		}
				break;
		case 3:
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
			best = new string[n];
			cout << "������ ������� " << endl;
			otbor(n, name, best);
			for (int i = 0; i < n; i++)
			{
				cout << best[i] << endl;
			}
			system("pause");
		}
		break;
		case 4:
		{
			int n, l, i;
			string *name, ctrl, tmp;
			cout << "������� ���-�� ��������� " << endl;
			cin >> n;
			cout << "������� ������ " << endl;
			name = new string[n];
			for (int i = 0; i < n; i++)
			{
				cin >> tmp;
				name[i] = tmp;
			}
			cout << "������� ������� " << endl;
			cin >> ctrl;
			l = 0;
			cout << "������ ��� �������" << linp(n, name, ctrl, l) << endl;
			system("pause");
		}
		break;
		case 5:
		{
			int n, s, f, L;
			string *name, ctrl;
			cout << "���-�� ��������� " << endl;
			cin >> n;
			name = new string[n];
			cout << "������� ������" << endl;
			for (int i = 0; i < n; i++)
			{
				cin >> name[i];
			}

			cout << "������� :" << endl;
			cin >> ctrl;
			cout << "������ ��� �������: " << binp(name, ctrl, n) << endl;

			system("Pause");
		}
				break;
				case 6:
				{
					int n, k = 0, *reit, l;
					string *name, *sp;
					double *ch, *sum;
					cout << "������� ���-�� ��������� " << endl;
					cin >> n;
					name = new string[n];
					ch = new double[n];
					sp = new string[n];
					reit = new int[n];
					sum = new double[n];
					for (int i = 0; i < n; i++)
					{
						cout << "�������� ������ � ���-�� " << endl;
						cin >> name[i] >> ch[i];
					}
					wsr(n, name, sp, ch, sum, reit, k);
					cout << "������ ��� ���������� ������� � ����� " << endl;
					for (int i = 0; i < k; i++)
					{
						cout << sp[i] << endl << reit[i] << endl << sum[i] << endl;
					}
					system("pause");
				}
						break;
				case 7:
				{
					int k=0, l;
					string *w, st, zn;
					cout << "������� ������ " << endl;
					getline(cin, st);
					w = new string[st.length() + 2];
					delim(st, w,k);
					cout << "����� " << endl;
					for (int i = 0; i < k; i++)
					{
						cout << w[i] << endl;
					}
					system("pause");
				}
						break;
				case 8:
				{
					int l, k=0, len;
					string st;
					string zn;
					string *w;
					setlocale(LC_ALL, "Rus");
					cout << "������� ������: " << endl;
					getline(cin, st);
					cout << "�����: " << endl;
					getline(cin, zn);
					w = new string[st.length() + 1];
					echedelim(w, zn, st, k);
					cout << "�����: " << endl;
					for (int i = 0; i < k; i++) {
						cout << w[i] << endl;
					}
					system("pause");
				}
						break;
				case 9: 
				{
					int n, m = 0;
					string *tk;
					string last;
					string *line;
					
					cout << "������� ���������� ����� " << endl;
					cin >> n;
					tk = new string[n];
					line = new string[1000 * n];
					last = ".!?";
					cout << "������� ����� � " << endl;
					for (int i = 0; i < n; i++) 
					{
						while (tk[i] == "")
						{
							getline(cin, tk[i]);
						}
					}
					predl(n, last, tk, line, m);
					cout << "��������������� ������" << endl;
					for (int i = 0; i <= m; i++)
					{
						cout << line[i] << endl;
					}
					system("pause");
				}
						break;
		}
	} while (pos != 0);
	system("pause");
	return 0;
}