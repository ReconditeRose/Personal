load "Primes.rb"

def concatPrimes(list)
  if(list.length() ==0)
    return true
  end
  a = 1
  while a< list.length()
    if(!isPrime((list[0].to_s+list[a].to_s).to_i))then
      
      return false
    end
    if(!isPrime((list[a].to_s+list[0].to_s).to_i))then
    
      return false
    end
    a+=1
  end
  return concatPrimes(list[1...list.length()])
end


def addPrime(list,depth)
  string = ""
  for a in list
    string += a.to_s + " "
  end
  puts string 
  
  if(list.length() == depth)then
    return list
  end
  a=1
  while($Primes[a]<list[-1])
    if(concatPrimes(list + [$Primes[a]]))then
      c = addPrime(list+[$Primes[a]],depth)
      if(c.length == depth)
        return c
      end
    end
    a+=1
  end
  return list
end

def main
  primeArray = []
  depth = 5
  while primeArray.length < depth
    iteratePrime
    primeArray = [$Primes[-1]]
    primeArray = addPrime(primeArray,depth)
  end
  
  sum = 0
  for a in primeArray
    sum+=a
  end
  return sum

end

main