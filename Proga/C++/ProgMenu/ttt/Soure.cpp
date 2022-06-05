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
	punktname[0] = "Выход";
	punktname[1] = "Сумма";
	punktname[2] = "Минимальный";
	punktname[3] = "Первая а";
	punktname[4] = "Линейный Поиск";
	punktname[5] = "Бинарный поиск";
	punktname[6] = "Список без повторений, рейтинг, сумма";
	punktname[7] = "Один разделитель";
	punktname[8] = "Несколько разделителей";
	punktname[9] = "Текст в предложения";
	do
	{
		pos = menu(punktname,n);
		switch (pos)
		{
		case 0: return 0; break;  //exit
		case 1: {
			int *a, n;
			setlocale(0, "");
			cout << "Кол-во чисел" << endl;
			cin >> n;
			a = new int[n];
			cout << "Введи числа" << endl;
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
			cout << "введите кол-во чисел" << endl;
			cin >> n;
			a = new int[n];
			cout << "Введите числа" << endl;
			for (int i = 0; i < n; i++)
			{
				cin >> a[i];
			}
			minimum(a, n, min, l);
			cout << "Min= " << min << endl << "Номер - " << l << endl;
			system("pause");
		}
				break;
		case 3:
		{
			int k, n;
			string *name, *best;
			setlocale(0, "");
			cout << "Кол-во эл " << endl;
			cin >> n;
			name = new string[n];
			cout << "Введи список " << endl;
			for (int i = 0; i < n; i++) {
				cin >> name[i];
			}
			best = new string[n];
			cout << "Список хороших " << endl;
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
			cout << "Введите кол-во элементов " << endl;
			cin >> n;
			cout << "Введите список " << endl;
			name = new string[n];
			for (int i = 0; i < n; i++)
			{
				cin >> tmp;
				name[i] = tmp;
			}
			cout << "Введите искомое " << endl;
			cin >> ctrl;
			l = 0;
			cout << "Найден под номером" << linp(n, name, ctrl, l) << endl;
			system("pause");
		}
		break;
		case 5:
		{
			int n, s, f, L;
			string *name, ctrl;
			cout << "Кол-во элементов " << endl;
			cin >> n;
			name = new string[n];
			cout << "Введите список" << endl;
			for (int i = 0; i < n; i++)
			{
				cin >> name[i];
			}

			cout << "Искомое :" << endl;
			cin >> ctrl;
			cout << "Найден под номером: " << binp(name, ctrl, n) << endl;

			system("Pause");
		}
				break;
				case 6:
				{
					int n, k = 0, *reit, l;
					string *name, *sp;
					double *ch, *sum;
					cout << "Введите кол-во элементов " << endl;
					cin >> n;
					name = new string[n];
					ch = new double[n];
					sp = new string[n];
					reit = new int[n];
					sum = new double[n];
					for (int i = 0; i < n; i++)
					{
						cout << "Название товара и Кол-во " << endl;
						cin >> name[i] >> ch[i];
					}
					wsr(n, name, sp, ch, sum, reit, k);
					cout << "Список без повторений Рейтинг и Сумма " << endl;
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
					cout << "Введите строку " << endl;
					getline(cin, st);
					w = new string[st.length() + 2];
					delim(st, w,k);
					cout << "Слова " << endl;
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
					cout << "Введите строку: " << endl;
					getline(cin, st);
					cout << "Знаки: " << endl;
					getline(cin, zn);
					w = new string[st.length() + 1];
					echedelim(w, zn, st, k);
					cout << "Слова: " << endl;
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
					
					cout << "Введите количество строк " << endl;
					cin >> n;
					tk = new string[n];
					line = new string[1000 * n];
					last = ".!?";
					cout << "Введите текст — " << endl;
					for (int i = 0; i < n; i++) 
					{
						while (tk[i] == "")
						{
							getline(cin, tk[i]);
						}
					}
					predl(n, last, tk, line, m);
					cout << "Преобразованный список" << endl;
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