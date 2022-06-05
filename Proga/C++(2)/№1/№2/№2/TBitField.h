#pragma once
#pragma once
#include "string"
using namespace std;
class TBitField
{
private:
	int* mem;
	int size;
public:
	int Get_Bit(int k) {
		return(k - 1) % (8 * sizeof(int));
	};
	int Get_Byte(int k) {
		return(k - 1) / (8 * sizeof(int));
	};
	//public:
	TBitField(int sizeU = 0) {
		size = ((sizeU / 8 * sizeof(int)) + 1);
		mem = new int[size];
		for (int i = 0; i < size; i++) {
			mem[i] = 0;
		}
	};
	~TBitField() {
		delete[]mem;
	};
	TBitField(const TBitField & tmp) {
		size = tmp.size;
		mem = new int[size];
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
	};
	TBitField&operator=(TBitField tmp) {
		if (size != tmp.size) {
			if (size != 0) {
				delete[]mem;
			}
			size = tmp.size;
			mem = new int[size];
		}
		for (int i = 0; i < size; i++) {
			mem[i] = tmp.mem[i];
		}
		return *this;
	};
	void add(int k) {
		mem[Get_Byte(k)] |= 1 << Get_Bit(k);
	};
	void del(int k) {
		mem[Get_Byte(k)] &= ~(1 << Get_Bit(k));
	};
	string TBitField_ToString(int sizeU) {
		int k;
		string str = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < sizeof(int) * 8; j++) {
				if ((mem[i] & (1 << j)) != 0) {
					k = i * 8 * sizeof(int) + j + 1;
					if (k <= sizeU) {
						str = (str + " ") + to_string(k);
					}
				}
			}
		}
		return(str);
	};
	TBitField operator^(TBitField tmp) {
		TBitField res(*this);
		for (int i = 0; i < res.size; i++) {
			res.mem[i] &= tmp.mem[i];
		}
		return res;
	};
	TBitField operator+(TBitField tmp) {
		TBitField res(*this);
		for (int i = 0; i < res.size; i++) {
			res.mem[i] |= tmp.mem[i];
		}
		return res;
	};
	TBitField operator~() {
		TBitField res(*this);
		for (int i = 0; i < size; i++) {
			res.mem[i] = ~res.mem[i];
		}
		return res;
	};
};


