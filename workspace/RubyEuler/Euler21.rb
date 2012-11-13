load "My Documents/Programming/Ruby/Primes.rb"

def amicable(number)
  count = 0
  array= allDivisors(number)
  for a in array[0..array.length-2]
    count += a
  end
  return count
end

total = 0

for b in 1..10000
  if(amicable(b) != b && b == amicable(amicable(b)))
    total+=b
    puts b
  end
end
puts total