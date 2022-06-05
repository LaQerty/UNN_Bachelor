#pragma once
#include "string"
#include"iostream"
#include"Header1.h"
//using namespace std;
class TSet
{
private:
	int size_U;
	TBitField* tbf_t;
	TBitField tbf;
	void sep_dif_w(std::string st, std::string *w, int &k)
	{
		int i, l;
		std::string zn = " .,";
		st += " ";
		for (int i = 0; i < st.length(); i++)
		{
			l = zn.find(st[i]);
			if (!((l >= 0) && (l < zn.length())))
			{
				w[k] += st[i];
			}
			else {
				if (st[i] == ' ')
				{
					if (w[k] != "")
					{
						w[++k] = "";
					}
				}
				else
				{
					if (w[k] != "")
					{
						w[++k] = st[i];
					}
					else
					{
						w[k] = st[i];
					}
					w[++k] = "";
				}
			}
		}
	}
public:
	TSet(int sizeU = 0)
	{
		size_U = sizeU;
		tbf_t = new TBitField(size_U);
		tbf = *tbf_t;
	};

	TSet(const TSet &tmp)
	{
		size_U = tmp.size_U;
		tbf = tmp.tbf;
	};

	TSet(int sizeU, std::string str)
	{
		size_U = sizeU;
		std::string* w;
		w = new std::string[sizeU];
		int count = 0;
		sep_dif_w(str, w, count);
		tbf_t = new TBitField(size_U);
		tbf = *tbf_t;
		for (int i = 0; i < count; i++)
		{
			int int_tmp = atoi(w[i].c_str());
			if (int_tmp > 0 && int_tmp <= size_U)
			{
				tbf.add(int_tmp);
			}
		}
	}

	~TSet() {

	};

	TSet &operator= (const TSet tmp)
	{
		size_U = tmp.size_U;
		tbf = tmp.tbf;
		return (*this);
	}

	void add(int k)
	{
		if (k > 0 && k <= size_U)
		{
			tbf.add(k);
		}
	}

	void del(int k)
	{
		if (k > 0 && k <= size_U)
		{
			tbf.del(k);
		}
	}

	TSet operator+ (TSet tmp)
	{
		TSet res(size_U);
		res.tbf = tbf + tmp.tbf;
		return res;
	}

	TSet operator^ (TSet tmp)
	{
		TSet res(size_U);
		res.tbf = tbf ^ tmp.tbf;
		return res;
	}

	TSet operator~ ()
	{
		TSet res(size_U);
		res.tbf = ~tbf;
		return res;
	}


	std::string TSet_ToStr()
	{
		return tbf.TBitField_ToString(size_U);
	}

};




