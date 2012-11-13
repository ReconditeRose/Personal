/*
 * Problem97.h
 *
 *  Created on: Mar 3, 2012
 *      Author: olsonmc
 */

#ifndef PROBLEM97_H_
#define PROBLEM97_H_

#include <sstream>

using namespace std;

class digitCarrier {
	int * carrier;
	int length;
public:
	void add(int);
	void multiply(int);
	digitCarrier(int);
	~digitCarrier();
	string returnValue();
};
string digitCarrier::returnValue() {
	std::string s;
	for (int i = length - 1; i >= 0; i--) {
		std::stringstream out;
		out << carrier[i];
		s += out.str();
	}
	return s;
}
digitCarrier::digitCarrier(int blank) {
	length = blank;
	carrier = new int[blank];
	for (int i = 0; i < length; i++) {
		carrier[i] = 0;
	}
}

digitCarrier::~digitCarrier() {
	delete carrier;
}

void digitCarrier::add(int addition) {
	for (int i = 0; i < length; i++) {
		carrier[i] = addition % 10;
		addition /= 10;
	}
}
void digitCarrier::multiply(int multiply) {
	for (int i = 0; i < length; i++) {
		carrier[i] *= multiply;
	}
	for (int i = 0; i < length; i++) {
		int index = 1;
		int temp = carrier[i];
		carrier[i] = temp % 10;
		temp /= 10;
		while (temp > 0) {
			if ((index + i) < length) {
				carrier[index + i] += temp % 10;
			}
			temp /= 10;
			index++;
		}
	}
}

class Problem97 {
public:
	string solve();
};

string Problem97::solve() {
//	digitCarrier a(10);
//	a.add(1);
//	for (int i = 0; i < 7830457; i++) {
//		a.multiply(2);
//	}
//	a.multiply(28433);
//	return a.returnValue();

	long long a = 28433;
	for (int i = 0; i < 7830457; i++) {
		a *= 2;
		a = a % 10000000000;
	}

	string s;
	std::stringstream out;
	out << a;
	s = out.str();
	return s;
}

#endif /* PROBLEM97_H_ */
