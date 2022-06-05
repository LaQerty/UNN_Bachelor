#include "my_string.h"
#include<iostream>
#include<string.h>
using namespace std;
int main()
{
	char q2 = 'q';
	string q1 = "q1";
	my_string v,a,b,z,sum,cop,minus,q,w,vint,izint;//1
	a = "aaa";//6 
	b = "bbbbb";
	v = "asniceasdasdasd";
		a = b;//5
		cout << a << endl;
		my_string c(a);//2
		cout << c << endl;
		my_string d("asdasdasdad");//4
		cout << d << endl;//7
		cout << "Vvod stroki i vivod" << endl;
		cin >> z;//8
		cout << "z="<<z<<endl;
		a = "123456";//9
		cout <<"Index"<<endl<< a[2] << endl;
		int ans = (a == b);//10
		cout << "Operator ==" << endl<< ans << endl;
		a = "aaa";
		int srav = (a < b), srav1 = (a > b);//11 & 12
		cout << "<>" << endl << srav << endl << srav1 << endl;
		sum = a + b;//13
		cout << "Summa my+my" << endl << sum << endl;
		sum = a + q1;// 14
		cout << "Summa my+string" << endl << sum << endl;
		sum = a + q2;
		cout << "Summa my+char" << endl << sum << endl;
		int len = a.len();//19
		cout << "Dlina" << endl << len << endl;
		cop=v.copy(2,4);//16
		cout << "Copy" << endl << cop << endl;
		minus = "hrpeori";
		minus.del(1, 5);//17
		cout << "Del" << endl << minus << endl;
		q = "qwe"; w = "aaaqweaaa";
		int poisk=w.find(q);//18
		cout << "Find" << endl << poisk << endl;
		vint = "12345";
		cout << vint << endl;
		int asd = vint.my_stringToInt();//20
		cout << "My_string To Int" << endl << asd << endl;
		int qwe = 1233321;
		izint.IntToMy_string(qwe);//21
		cout << "IntToMy_string" << endl << izint << endl;
		system("pause");
		return 0;
}
