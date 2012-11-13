load "Primes.rb"

primeLength=2
max = 1
maxPrime = 2

initial = -1
high = 1000000

puts isPrime(52)

while(high/$Primes[initial] > max)
initial+=1
  combo = 0
  combine = 0
  while(combine<high)
    while(combo+initial > primeLength)
      iteratePrime()
      primeLength+=1
    end
    combine += $Primes[initial+combo]
    if(isPrime(combine)==1)then
      if(combo+1>max)then
        max = combo+1
        maxPrime = combine
      end
    end
    combo+=1
  end
end

puts max
puts maxPrime