$Primes = [2,3,5]

def checkComposite(number)
  b=$Primes.length
  exception = true;

  while(b>0 and exception == true)
    b-=1
    a=0
    while($Primes[b] + a*a*2 < number and exception == true)
      a+=1
      if($Primes[b]+a*a*2 == number)then
        exception = false
      end
    end
  end
  return exception
end

goal = false
a = $Primes[$Primes.length-1]

while(!goal)
    a+=2
    for b in $Primes
      if(a%b==0)
        goal = checkComposite(a)
        break
      end
      if(a/b<b)
        $Primes += [a]
        break
      end
    end
end
puts a