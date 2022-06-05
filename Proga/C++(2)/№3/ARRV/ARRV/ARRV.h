#pragma once
#include"cPoliz.h"
#include<string>
using namespace std;
class ARRV
{private:
	string str;
	cPoliz tmp;
public:
	ARRV(string _str) {
		if (_str[_str.length() - 1] == ')') {
			str += "+0";
		}
		str = _str;
		tmp = cPoliz(str);
	}
	ARRV(const ARRV&_tmp) {
		str = _tmp.str;
		tmp = _tmp.tmp;
	}
	//ARRV&operator =(const ARRV&_tmp) {
	//	str = _tmp.str;
	//	//delete tmp;
	//	tmp = _tmp.tmp;
	//	return *this;
	//}
	~ARRV() {}
	double calculate() {
		Stack<double> st(tmp.get_count_pol());
		double left, right;
		for (int i = 0; i < tmp.get_count_pol(); i++) {
			int k = tmp.get_table_operand()->search_line(tmp[i]);
			if (k != -1) {
				st.push(tmp.get_table_operand()->GetV(tmp[i]));
			}
			else {
				right = st.pop();
				left = st.pop();
				if (tmp[i] == "+")st.push(left + right);
				else if (tmp[i] == "-")st.push(left - right);
				else if (tmp[i] == "*")st.push(left*right);
				else if (tmp[i] == "/")st.push(left / right);
				else if (tmp[i] == "^")st.push(pow(left,right));
			}
		}
		return st.pop();
	}
	cPoliz getPoliz() {
		return tmp;
	}
};

