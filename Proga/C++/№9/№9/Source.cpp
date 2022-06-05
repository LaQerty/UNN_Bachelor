#include<cstring> 
#include<iostream>
#include<string> 
using namespace std;
int main() {
	setlocale(0, "");
	int k, l;
	string *w, st, zn;
	cout << "Введите строку " << endl;
	getline(cin,st);
	st += ' ';
	w = new string[st.length() + 2];
	k = 0;
	while (st.length() > 0)
	{
		l = st.find(" ");
		if (l > 0)
		{
			w[k++] = st.substr(0, l);
			st.erase(0, l + 1);
		}
		else
		{
			st.erase(0, l + 1);
		}
	}
	cout << "Слова " << endl;
	for (int i = 0; i < k; i++)
	{
		cout << w[i]<<endl ;
	}
	system("pause");
	return 0;
}