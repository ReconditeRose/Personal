$Primes = [2,3,5]

def iteratePrime
  a = $Primes[$Primes.length-1]
  isPrime=0
  while(isPrime ==0)
    a+=2
    isPrime=1
    for b in $Primes
      if(a%b==0)
        isPrime=0
        break
      end
      if(a/b<b)
        isPrime=1
        break
      end
    end
  end
  $Primes += [a]
end

def isPrime(number)
  a=number
  isPrime=false
  b=1
  
  if(a%2==0)
    return false
  end
  while b < number
    b+=2
    if(a%b==0)
      break
    end
    if(a/b<b)
      isPrime = true
      break
    end
  end

  return isPrime
end

def primeDivisors(number)
  array = []
  while(number > $Primes[$Primes.length-1])
    iteratePrime
  end
  for a in $Primes
    while(number%a==0)
      number/=a
      array += [a]
    end
    if(a>number)
      break
    end
  end
  return array
end

def allDivisors(number)
  array = primeDivisors(number)
  totalArray=[1]
  for a in array.uniq
    tempArray=totalArray
    for b in 1..array.count(a)
      for c in totalArray
        tempArray+= [c*a**b]
      end
    end
    totalArray=tempArray
  end
  return totalArray
end

