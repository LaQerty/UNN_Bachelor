#include "Stack.h"
#include<iostream>

using namespace std;
int main() {
	Stack<int> a(3);
	Stack<int> b(a);
	a.push(2);
	a.push(3);
	int k = a.IsEmpty();
	if (k == 1) cout << "Pusto" << endl;
	else cout << "Ne pusto" << endl;
	a.push(4);
	k = a.IsFull();
	if (k == 1) cout << "Polnyi" << endl;
	else cout << "Ne polnyi" << endl;
	b = a;
		int x = a.top();
	 cout <<"a/top1="<< x << endl;
	 
	 x = a.pop();
	 cout <<"a/pop1="<< x << endl;
	 x = a.pop();
	 cout << "a/pop2=" << x << endl;
	 x = a.pop();
	 cout << "a/pop3=" << x << endl;
	

	 x = b.pop();
	 cout << "b/pop1=" << x << endl;
	 x = b.pop();
	 cout << "b/pop2=" << x << endl;

    system("pause");
}