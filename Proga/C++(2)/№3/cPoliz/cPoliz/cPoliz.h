#pragma 
#include<string>
#include"Header.h"
#include"Header1.h"
#include"Header2.h"
using namespace std;
class cPoliz
{private:
	string *poliz;
	int size_pol;
	int count_pol;
	Table<double>* tab_per;
	Table<int>* tab_prior;
	Stack<Line<int>> stack_prior;
	
	void DivingLineWithOther(string st, string *w, int &k) {
		string zn = "+-*/^() ";
		int i, l;
		st += " ";
		for (i = 0; i < st.length(); i++) {
			l = zn.find(st[i]);
			if (!((l >= 0) && (l < zn.length()))) {
				w[k] += st[i];
			}
			else {
				if (st[i] == ' ') {
					if (w[k] != "") {
						//w[++k] = ""; 
					}
				}
				else {
					if (w[k] != "") {
						w[++k] = st[i];
					}
					else {
						w[k] = st[i];
					}
					w[++k] = "";
				}
			}
		}
	}

	void made_tab_prior() {
		tab_prior = new Table<int>(5);
		tab_prior->push(Line<int>("+", 1));
		tab_prior->push(Line<int>("-", 1));
		tab_prior->push(Line<int>("*", 2));
		tab_prior->push(Line<int>("/", 2));
		tab_prior->push(Line<int>("^", 3));
	   // tab_prior->push(Line<int>("(", 3));
		//tab_prior->push(Line<int>(")", 3));
	}
	void left_brecket() {
		if (!stack_prior.IsFull()) {
			stack_prior.push(Line<int>("("));
		}
	}
	void right_brecket() {
		while (!stack_prior.IsEmpty() && stack_prior.top().getN() != "(")
		{
		    poliz[count_pol++] = stack_prior.pop().getN();
		}
		stack_prior.pop();
	}
	void operand(string op) {
		poliz[count_pol++] = op;
		int bool_ = 1;
		for (int i = 0; i < tab_per->getCount() && bool_; i++) {
			if (tab_per->search_line(op) != -1) {
				bool_ = 0;
			}
		}
		if (bool_) {
			if (int(op[0]) > 48 && int(op[0]) < 58) {
				tab_per->push(Line<double>(op, double(stoi(op))));
			}
			else {
				tab_per->push(Line<double>(op));
			}
		}
	}
	void operation(Line<int> tmp) {
		while ((stack_prior.IsEmpty() != 1) && (stack_prior.top().getV() >= tmp.getV())) {
			poliz[count_pol++] = stack_prior.pop().getN();
		}
		stack_prior.push(tmp);
	}
	void end_of() {
		while (stack_prior.IsEmpty() != 1) {
			poliz[count_pol++] = stack_prior.pop().getN();
		}
	}
	void made_poliz(string tmp) {
		string zn = "+-*/^() ";
		string *w = new string[tmp.length()];
		int k = 0;
		DivingLineWithOther(tmp, w, k);
		count_pol = 0;
		for (int i = 0; i <= k; i++) {
			int tmp = zn.find(w[i]);
			if (tmp >= 0) {
				if (w[i] == "(") {
					left_brecket();
				}
				else if (w[i] == ")") {
					right_brecket();
				}
				else if (w[i] != "") {
					operation(Line<int>(w[i], tab_prior->GetV(w[i])));
				}

			}
			else operand(w[i]);
		}
		end_of();
	}
public:
	cPoliz(string str = "") {
		size_pol = str.length() + 1;
		str += " ";
		poliz = new string[size_pol];
		count_pol = 0;
		made_tab_prior();
		tab_per = new Table<double>(size_pol / 2 +1);
		stack_prior = Stack<Line<int>>(size_pol / 2 +1);
		//if (size != 1) {
			made_poliz(str);
		//}
	}
	~cPoliz() {
		delete[]poliz;
//		delete[]tab_per;
	}
	cPoliz(const cPoliz &tmp) {
		size_pol = tmp.size_pol;
		poliz = new string[size_pol];
		count_pol = tmp.count_pol;
		made_tab_prior();
		tab_per = new Table<double>(size_pol / 2);
		(*tab_per) = (*(tmp.tab_per));
		stack_prior = Stack<Line<int>>(size_pol / 2);
		for (int i = 0; i < count_pol; i++) {
			poliz[i] = tmp.poliz[i];
		}
	}
	cPoliz&operator=(const cPoliz&tmp) {
		if (size_pol != tmp.size_pol) {
			if (size_pol != 0) {
				delete[]poliz;
			}
			size_pol = tmp.size_pol;
			poliz = new string[size_pol];
		}
		count_pol = tmp.count_pol;
		for (int i = 0; i < count_pol; i++)
		{
			poliz[i] = tmp.poliz[i];
		}
		made_tab_prior();
		if (tab_per->getCount()) {
			delete[]tab_per;
		}
		tab_per = new Table<double>(size_pol);
		(*tab_per) = (*(tmp.tab_per));
		stack_prior = Stack<Line<int>>(size_pol / 2);
		return *this;
	}
	string get_pol() {
		string res = "";
		for (int i = 0; i < count_pol; i++) {
			res += poliz[i] + " ";
		}
		return res;
	}
	string operator[](int k) {
		if ((k >= 0) && (k < count_pol)) {
			return poliz[k];
		}
		else return "";
	}
	int get_count_pol() {
		return count_pol;
	}
	Table<double>* get_table_operand() {
		return tab_per;
	}

};

