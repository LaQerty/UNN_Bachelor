#include "circle_list.h"

#define deb(a) cout << #a << " = " << a << endl;

circle_list::circle_list() {
	head = new monom(0, -1);
	head->set_nxt(head);
}

circle_list::circle_list(const circle_list & tmp) {
	if (tmp.head->get_nxt() == tmp.head) {
		if (tmp.head->get_k() != 0) {
			std::cout << " circle_list";
			throw  1;
		}
		head = new monom(0, -1);
		head->set_nxt(head);
		return;
	}
	head = new monom(*(tmp.head));
	monom* last = head;
	monom* cur = tmp.head->get_nxt();
	while (cur != tmp.head) {
		monom* now = new monom(*(cur));
		last->set_nxt(now);
		last = last->get_nxt();
		cur = cur->get_nxt();
	}
	last->set_nxt(head);
}

circle_list::~circle_list() {
	monom* cur = head;
	while (cur->get_nxt() != head) {
		cur = cur->get_nxt();
	}
	cur->set_nxt(nullptr);
	delete head;
}

circle_list & circle_list::operator=(const circle_list & tmp) {
	if (this == &tmp) return *this;
	monom* cur = head;
	while (cur->get_nxt() != head) {
		cur = cur->get_nxt();
	}
	cur->set_nxt(nullptr);
	delete head;
	head = new monom(*(tmp.head));
	cur = tmp.head->get_nxt();
	monom* last = head;
	while (cur != tmp.head) {
		monom* now = new monom(*cur);
		last->set_nxt(now);
		last = last->get_nxt();
		cur = cur->get_nxt();
	}
	last->set_nxt(head);
	return *this;
}

void circle_list::plus(const monom & tmp) {
	if (tmp.get_sv() == -1 || tmp.get_k() == 0) return;
	if (head->get_nxt() == head) {
		monom* kek = new monom(tmp);
		kek->set_nxt(head);
		head->set_nxt(kek);
		return;
	}
	monom* last = head->get_nxt();
	while (last != head) {
		if (last->get_sv() == tmp.get_sv()) {
			double gg = last->get_k();
			gg += tmp.get_k();
			last->set_k(gg);
			if (gg == 0) {
				erase(tmp);
			}
			return;
		}
		last = last->get_nxt();
	}
	last = head;
	while (last->get_nxt() != head) {
		if (last->get_nxt()->get_sv() < tmp.get_sv()) {
			monom* kek = new monom(tmp);
			kek->set_nxt(last->get_nxt());
			last->set_nxt(kek);
			return;
		}
		last = last->get_nxt();
	}

	monom* kek = new monom(tmp);
	kek->set_nxt(head);
	last->set_nxt(kek);
}

void circle_list::minus(const monom & tmp) {
	monom kek = tmp;
	kek.set_k(-kek.get_k());
	plus(kek);
}

void circle_list::erase(const monom & tmp) {
	monom* last = head->get_nxt();
	while (last != head) {
		if (last->get_sv() == tmp.get_sv()) {
			monom* kek = head;
			while (kek->get_nxt() != last) {
				kek = kek->get_nxt();
			}
			kek->set_nxt(last->get_nxt());
			last->set_nxt(nullptr);
			delete last;
			break;
		}
		last = last->get_nxt();
	}
}

circle_list circle_list::operator+(const circle_list & tmp) {
	circle_list res;
	monom* last = head->get_nxt();
	while (last != head) {
		res.plus(*last);
		last = last->get_nxt();
	}
	last = tmp.head->get_nxt();
	while (last != tmp.head) {
		res.plus(*last);
		last = last->get_nxt();
	}
	return res;
}

circle_list circle_list::operator-(const circle_list & tmp) {
	circle_list res;
	monom* last = head->get_nxt();
	while (last != head) {
		res.plus(*last);
		last = last->get_nxt();
	}
	last = tmp.head->get_nxt();
	while (last != tmp.head) {
		res.minus(*last);
		last = last->get_nxt();
	}
	return res;
}

circle_list circle_list::operator*(double kek) {
	circle_list res(*this);
	monom* last = res.head->get_nxt();
	while (last != res.head) {
		last->set_k(last->get_k() * kek);
		last = last->get_nxt();
	}
	while (1) {
		last = res.head->get_nxt();
		int ok = 1;
		while (last != res.head) {
			if (last->get_k() == 0) {
				res.erase(*last);
				ok = 0;
				break;
			}
			last = last->get_nxt();
		}
		if (ok) break;
	}
	return res;
}

std::string circle_list::to_string(int max_step, int n) {
	std::string ans;
	monom* last = head->get_nxt();
	while (last != head) {
		ans += last->calc_monom(max_step, n);
		last = last->get_nxt();
	}
	if (ans.size() == 0) ans += "+0";
	return ans;
}

circle_list circle_list::mult(const circle_list & _1, int max_step, int n) {
	circle_list res;
	monom* last_1 = head->get_nxt();
	while (last_1 != head) {
		monom* last_2 = _1.head->get_nxt();
		while (last_2 != _1.head) {
			monom ans = last_1->mult(*last_2, max_step, n);
			res.plus(ans);
			last_2 = last_2->get_nxt();
		}
		last_1 = last_1->get_nxt();
	}
	return res;
}