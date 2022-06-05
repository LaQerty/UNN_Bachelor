#include<cstring> 
#include<iostream>
#include<string> 
using namespace std;
int main() {
	setlocale(0, "");
	int n, k=0, *reit, l;
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
	for (int i = 0; i < n; i++)
	{
		l = -1;
		int j = 0;
		while ((l == -1) && (j < k))
		{
			if (sp[j]==name[i])
			{
				l = j;
			}
			j++;
		}
		if (l == -1)
		{
			sp[k] = name[i];
			reit[k] = 1;
			sum[k] = ch[i];
			k++;
		}
		else
		{
			reit[l]++;
			sum[l] += ch[i];
		}
	}
	cout<<"Список без повторений Рейтинг и Сумма "<<endl;
	for (int i = 0; i < k; i++)
	{
	cout<<sp[i]<<endl<<reit[i]<<endl<<sum[i]<<endl;
	}
	system("pause");
	return 0;
}