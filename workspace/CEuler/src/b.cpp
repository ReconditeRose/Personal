/*
 * b.cpp
 *
 *  Created on: Mar 3, 2012
 *      Author: olsonmc
 */

#include <cmath>
#include <iostream>
#include "Problem113.h"
#include <time.h>
#include <stdio.h>

using namespace std;

int main(){
	Problem113 a;
	long t = clock();
	printf("%d\n", a.solve());
	printf("Time elapsed:%d ms",(clock()-t));
	return 1;
}
