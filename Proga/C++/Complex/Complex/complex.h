#pragma once
#include<math.h>
#include<iostream>
#include<string>
#include"delit.h"
using namespace std;
class complex
{private:
	int Re, Im;
	double modul;
	double getmod() {return sqrt((double)(Re*Re + Im * Im));}
public:
	complex(int _Re = 0, int _Im = 0)
	{
		Re = _Re;
		Im = _Im;
		modul = getmod();
	}
	~complex() {}
	complex(const complex& tmp)
	{
		Re = tmp.Re;
		Im = tmp.Im;
		modul = tmp.modul;
	}
	int getRe() {return Re;}
	int getIm() { return Im; }
	double getmodul() { return modul; }
	void setRe(int _Re) { Re = _Re; modul = getmod(); }
	void setIm(int _Im) { Im = _Im; modul = getmod(); }
	complex operator+(complex tmp) 
	{
		complex res;
		res.Re = Re + tmp.Re;
		res.Im = Im + tmp.Im;
		res.modul = res.getmod();
		return res;
	}
	complex operator-(complex tmp)
	{
		complex res;
		res.Re = Re - tmp.Re;
		res.Im = Im - tmp.Im;
		res.modul = res.getmod();
		return res;
	}
	complex operator*(complex tmp) 
	{
		complex res;
		res.Re = Re * tmp.Re+Im*tmp.Im;
		res.Im = Im * tmp.Re+Re*tmp.Im;
		res.modul = res.getmod();
		return res;	
	}
	complex operator/(complex tmp)
	{
		complex res;
		int znak = tmp.Re*tmp.Re + tmp.Im*tmp.Im;
		res.Re = (Re * tmp.Re + Im * tmp.Im)/znak;
		res.Im = (Im * tmp.Re - Re * tmp.Im)/znak;
		res.modul = res.getmod();
		return res;
	}
	friend ostream &operator<< (ostream& out, complex tmp)
	{
		if (tmp.Re != 0)
		{
			out << tmp.Re;
		}
		if (tmp.Im > 0)
		{
			out << "+";
		}
		if (tmp.Im != 0)
		{
			out << tmp.Im << "i";
		}
		if ((tmp.Re == 0) && (tmp.Im == 0))
		{
			out << 0;
		}
		return out;
	}
	friend istream& operator>> (istream& in, complex &tmp)//ввод
	{
		string str;
		getline(in, str);
		string w[4];
		int k;
		echedelim(w, "+- ",str, k);
		tmp.Re = 0;
		tmp.Im = 0;
		for (int i = 0; i < k; i++)
		{
			int l = w[i].find("i");
			if ((l >= 0) && (l < w[i].length()))
			{
				w[i].erase(l, 1);
				if ((w[i] == "") || (w[i] == "+") || (w[i] == "-"))
				{
					w[i] += "1";
				}
				tmp.Im = stoi(w[i]);
			}
			else { tmp.Re = stoi(w[i]); }
		}
		tmp.modul = tmp.getmod();
		return in;
	}
};
