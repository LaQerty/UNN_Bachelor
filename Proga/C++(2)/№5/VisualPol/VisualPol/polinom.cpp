#include "polinom.h"
#include"monom.h"

std::string * polinom::processing_string(std::string s, int & k) {
	std::string zn = "+-";
	k = 0;
	std::string * w = new std::string[(s.size() + 1) / 2];
	get_words_diff_razdel(s, zn, w, k);
	for (int i = 0; i < k; i++) {
		while (1) {
			int pos = (int)w[i].find(" ");
			if (pos == -1) break;
			w[i].erase(pos, 1);
		}
	}
	return w;
}
void polinom::get_words_diff_razdel(std::string st, std::string zn, std::string * w, int & k) {
	for (int i = 0; i < st.size(); i++) {
		if (zn.find(st[i]) == -1) {
			w[k].push_back(st[i]);
		}
		else {
			if (w[k].size() > 0) {
				k++;
			}
			w[k] += st[i];
		}
	}
	if (w[k].size()) k++;
}

polinom::polinom(std::string _s, int _cnt, int _max_step) {
	cnt = _cnt;
	max_step = _max_step;
	if (_s.size() == 0) return;
	int sz_w = 0;
	std::string * w = processing_string(_s, sz_w);

	for (int i = 0; i < sz_w; i++) {
		monom tmp(w[i], max_step, cnt);
		CL.plus(tmp);
	}
}

polinom::polinom(const polinom & tmp) {
	cnt = tmp.cnt;
	max_step = tmp.max_step;
	CL = tmp.CL;
}

polinom & polinom::operator=(const polinom & tmp) {
	if (this == &tmp) return *this;
	cnt = tmp.cnt;
	CL = tmp.CL;
	max_step = tmp.max_step;
	return *this;
}

void polinom::add(const monom & tmp) {
	CL.plus(tmp);
}

void polinom::erase(const monom & tmp) {
	CL.minus(tmp);
}

polinom polinom::operator+(const polinom & tmp) {
	polinom res(*this);
	res.CL = res.CL + tmp.CL;
	return res;
}

polinom polinom::operator-(const polinom & tmp) {
	polinom res(*this);
	res.CL = res.CL - tmp.CL;
	return res;
}

polinom polinom::operator*(double kk) {
	polinom res(*this);
	res.CL = res.CL * kk;
	return res;
}

polinom polinom::operator*(const polinom & tmp) {
	polinom res(*this);
	res.CL = res.CL.mult(tmp.CL, max_step, cnt);
	return res;
}

std::string polinom::to_string() {
	std::string ans = CL.to_string(max_step, cnt);
	return ans;
}