#include "ARRV.h"
#include <iostream>
#include<string>
using namespace std;
int main() {
	int q, w, e, d, f;
	/*string z;
	ARRV a("1+1");
	cin >> z;
	ARRV b(z);
	ARRV c("1+1");
	cout<< "a="<<a.calculate()<<endl;
	cout <<"b="<< b.calculate() << endl;
	cout<<b.getPoliz().get_pol()<<endl;*/
	ARRV qwe("q+w/e-3+d*f-34");
	
	Table<double> tbl;
	tbl = *(qwe.getPoliz().get_table_operand());
	for (int i = 0; i < tbl.getCount(); i++) {
		if (tbl[i].getV()) {
			cout << tbl[i].getN() << ":\t" << tbl[i].getV() << endl;
		}
	}
	cout << "qwe=" << qwe.calculate() << endl;
	cout << qwe.getPoliz().get_pol() << endl;
	
	system("pause");
}