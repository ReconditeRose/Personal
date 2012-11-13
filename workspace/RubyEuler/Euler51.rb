load "Primes.rb"
#TODO FIX
def countPrimes(number)
  positions = []
  for a in 0...number.length()
    if(number[a]=="1")then
      positions +=[a]
    end
  end
  total = 0
  numC = number
  for a in 0..9
    numT = numC
    for b in positions
      numT[b] = a.to_s
    end
    if(isPrime(numT.to_i)==1)then
      total+=1
    end
  end
  return total
end

def addSlots(number,slots)
  total = []
  if(slots==0)
    return [number]
  end
  for a in 1..number.length
    newNumber = number[0,a] +"*"+number[a,number.length-1]
    total+= addSlots(newNumber,slots-1)
  end
  return total
end

def main
  goal = 8
  b=1001
  while 1
    b+=2
    
        if(countPrimes(b.to_s)==goal)then
          return b
        end
  end
end

puts main
