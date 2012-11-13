/*
 * Primes.h
 *
 *  Created on: Jun 30, 2012
 *      Author: olsonmc
 */

#ifndef PRIMES_H_
#define PRIMES_H_
bool isPrime(long a){
	if(a%2==0){
		if(a==2){
		return false;
		}else{
			return true;
		}
	}
	for(long i = 3; i*i<a;i+=2){
		if(a%i==0){
			return true;
		}
	}
	return false;
}

long GCD(long a,long b){
	if(b==0)
		return a;
	return GCD(b,a%b);
}

#endif /* PRIMES_H_ */
