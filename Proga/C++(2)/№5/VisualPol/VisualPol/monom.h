#pragma once
#include<string>


class monom {
private:
	long long sv;
	double k;
	monom* nxt;
	double calc_k(std::string s);
	long long calc_sv(std::string s, int max_step, int n);
	long long calc_sv(int* pw, int max_step, int n);
	void calc_pw(long long sv, int max_step, int n, int *pw);
public:
	monom(double _k, long long _sv);
	monom(std::string s, int max_step, int n);
	~monom();
	monom mult(const monom& tmp, int max_step, int n);
	monom(const monom& kek);
	monom& operator= (const monom& kek);
	std::string calc_monom(int max_step, int n);
	long long get_sv() const {
		return sv;
	}
	double get_k() const {
		return k;
	}
	monom* get_nxt() {
		return nxt;
	}
	void set_sv(long long _sv) {
		sv = _sv;
	}
	void set_k(double _k) {
		k = _k;
	}
	void set_nxt(monom * kek) {
		nxt = kek;
	}
	bool operator==(const monom & a) const {
		return sv == a.sv && k == a.k;
	}
};
