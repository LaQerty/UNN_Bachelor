#pragma once
#include <iostream>
using namespace std;
class zveno
{private:
	int info;
	zveno *next;
public:
	zveno(int _info = 0) {
		info = _info;
		next = nullptr;
	};
	zveno(const zveno&tmp) {
		next = nullptr;
		info = tmp.info;
	}
	zveno&operator=(const zveno&tmp) {
		next = nullptr;
		info = tmp.info;
		return *this;
	}
	~zveno() {
		delete next;
	}
	int get_info() {
		return info;
	}
	void set_info(int k) {
		info = k;
	}
	zveno* get_next() {
		return next;
	}
	void set_next(zveno* k) {
		next=k;
	}
};
class link
{
private:
	zveno* first;
	zveno* last;
public:
	link() {
		first = nullptr;
		last = nullptr;
	}

	link(const link &tmp) {
		if (tmp.first == nullptr) {
			last = first = tmp.first;
		}
		else {
			first = new zveno(*(tmp.first));
			zveno* curr = tmp.first->get_next();
			while (curr != NULL) {
				zveno* copy_curr = new zveno(*(curr));
				last->set_next(copy_curr);
				last = last->get_next();
				curr = curr->get_next();
			}
		}
	}

	link &operator= (const link &tmp) {
		if (tmp.first == 0) {
			last = first = tmp.first;
		}
		else {
			first = new zveno(*(tmp.first));
			zveno* curr = tmp.first->get_next();
			while (curr != NULL) {
				zveno* copy_curr = new zveno(*(curr));
				last->set_next(copy_curr);
				last = last->get_next();
				curr = curr->get_next();
			}
		}
	}

	~link() {
		delete first;
		last = first = nullptr;
	}

	void push(int k) {
		if (last != nullptr) {
			last->set_next(new zveno(k));
			last = last->get_next();
		}
		else {
			last = first = new zveno(k);
		}
	}

	int del() {
		if (last == nullptr && first == nullptr) {
			throw - 1;
		}
		else {
			int res = first->get_info();
			first = first->get_next();
			return res;
		}
	}

	void print() {
		zveno* a = first;
		cout << first << " || ";
		while (a != nullptr) {
			cout << a->get_info() << " : " << a->get_next() << " || ";
			a = a->get_next();
		}
		cout << "nullptr" << endl;
	}

};

