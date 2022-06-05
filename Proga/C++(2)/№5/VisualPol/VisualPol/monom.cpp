#include "monom.h"
#include<string>
#include<iostream>
#include<algorithm>

#define deb(a) cout << #a << " = " << a << endl;

double monom::calc_k(std::string s) {
	std::string ans;
	int ind = 0;
	while (ind < s.size()) {
		if (s[ind] >= 'a' && s[ind] <= 'z') break;
		ans += s[ind++];
	}
	if (ans.size() == 0) return 1;
	else if (ans.size() == 1 && ans == "-") return -1;
	return atof(ans.c_str());
}

long long monom::calc_sv(std::string s, int max_step, int n) {
	int* pw = new int[n];
	for (int i = 0; i < n; i++) pw[i] = 0;
	for (int i = n - 1; i >= 0; i--) {
		std::string vari = 'x' + std::to_string(i);
		//cout << "! " << vari << '\n';
		//cout << "!! " << s << '\n';
		int ind = s.find(vari);
		int st = ind;
		//cout << "!!! " << ind << '\n';
		if (ind < 0 || ind >= s.size()) continue;
		if (ind + vari.size() >= s.size()) {
			pw[i] = 1;
		}
		else {
			if (s[ind + vari.size()] == '^') {
				std::string kk;
				ind += vari.size() + 1;
				while (ind < s.size()) {
					if (s[ind] >= 'a' && s[ind] <= 'z') break;
					kk += s[ind++];
				}
				pw[i] = atoi(kk.c_str());
				if (pw[i] >= max_step) {
					return -1;
				}
			}
			else {
				pw[i] = 1;
			}
		}
		s.erase(st, ind - st);
		//cout << pw[i] << '\n';
	}
	long long res(0);
	long long gg = 1;
	for (int i = 0; i < n; i++) {
		res += gg * pw[i];
		gg *= max_step;
	}
	res = std::max(-1ll, res);
	return res;
}

void monom::calc_pw(long long _sv, int max_step, int n, int *pw) {
	for (int i = 0; i < n; i++) pw[i] = 0;
	int ind = 0;
	while (_sv) {
		pw[ind++] = _sv % max_step;
		_sv /= max_step;
	}
}

long long monom::calc_sv(int* pw, int max_step, int n) {
	long long res(0);
	long long gg = 1;
	for (int i = 0; i < n; i++) {
		res += gg * pw[i];
		gg *= max_step;
	}
	return res;
}

monom::monom(double _k, long long _sv) {
	k = _k;
	sv = _sv;
	nxt = this;
}

monom::monom(std::string s, int max_step, int n) {
	sv = calc_sv(s, max_step, n);
	k = calc_k(s);
	nxt = this;
}

monom::~monom() {
	nxt = NULL;
}

monom monom::mult(const monom& tmp, int max_step, int n) {
	if (sv == -1 || tmp.sv == -1) {
		monom res(-1, -1);
		return res;
	}
	int* pw1 = new int[n];
	int* pw2 = new int[n];
	calc_pw(sv, max_step, n, pw1);
	calc_pw(tmp.sv, max_step, n, pw2);
	long long ans_sv = 0;
	for (int i = 0; i < n; i++) {
		pw1[i] += pw2[i];
		if (pw1[i] >= max_step) {
			ans_sv = -1;
			break;
		}
	}
	if (ans_sv == -1) {
		monom res(-1, -1);
		return res;
	}
	ans_sv = calc_sv(pw1, max_step, n);
	monom res(k * tmp.k, ans_sv);
	return res;
}

monom::monom(const monom& kek) {
	sv = kek.sv;
	k = kek.k;
	nxt = this;
}

monom& monom::operator=(const monom& kek) {
	sv = kek.sv;
	k = kek.k;
	nxt = this;
	return *this;
}

std::string monom::calc_monom(int max_step, int n) {
	if (sv == -1) {
		return "+0";
	}
	std::string ans;
	int* pw = new int[n];
	calc_pw(sv, max_step, n, pw);
	if (k > 0) ans += '+';
	if (k != 1) ans += std::to_string(k);
	for (int i = n - 1; i >= 0; i--) {
		std::string vari = 'x' + std::to_string(i);
		if (pw[i] == 0) continue;
		ans += vari;
		if (pw[i] == 1) continue;
		ans += '^' + std::to_string(pw[i]);
	}
	if (ans.back() == '+') ans += '1';
	if (ans.size() == 0) ans += '0';
	return ans;
}