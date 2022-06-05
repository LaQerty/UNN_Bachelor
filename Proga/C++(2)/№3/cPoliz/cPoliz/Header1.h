#pragma once
#include<string>
using namespace std;
template <class T>
class Line
{
private:
	T value;
	string name;
public:
	Line<T>(string _name = "", T _value = 0) {
		name = _name;
		value = _value;
	}
	~Line() {};
	string getN() {
		return name;
	}
	T getV() {
		return value;
	}
	void setV(T tmp) {
		value = tmp;
	}
};


