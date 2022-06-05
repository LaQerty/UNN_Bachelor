//#pragma once
//#include"monom.h"
//#include<iostream>
//
//class circle_list {
//private:
//	monom *head;
//public:
//	circle_list();
//	circle_list(const circle_list & tmp);
//	~circle_list();
//	circle_list &operator=(const circle_list & tmp);
//	void plus(const monom & tmp);
//	void minus(const monom & tmp);
//	void erase(const monom & tmp);
//	circle_list operator+(const circle_list & tmp);
//	circle_list operator-(const circle_list & tmp);
//	circle_list operator*(double kek);
//	string to_string(int max_step, int n);
//	monom* get_head() const {
//		return head;
//	}
//	circle_list mult(const circle_list & _1, int max_step, int n);
//};
#pragma once

#include "monom.h"

#include <iostream>

class ListCircle

{

private:

	Monom* head;

public:

	ListCircle();

	ListCircle(const ListCircle& tmp);

	~ListCircle();

	ListCircle& operator= (const ListCircle& tmp);

	void Add(const Monom& tmp);

	ListCircle operator+ (const ListCircle& tmp);

	ListCircle operator- (const ListCircle& tmp);

	ListCircle operator* (double k);

	void minus(const Monom& tmp);

	ListCircle mult(const ListCircle& _1, int max_step, int n);

	std::string getList(int max_st, int n);

	void erase(const Monom& tmp);

	Monom* get_head() const

	{

		return head;

	}

};