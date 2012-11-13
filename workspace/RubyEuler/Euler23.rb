load "My Documents/Primes.rb"

abundantNumbers = []
sumNumbers = []
goto = 28123

for b in 1..goto
sum = -b
for c in allDivisors(b)
sum+=c
end
if(sum>b)
abundantNumbers+=[b]
end
end
puts "Done Compiling abundant Numbers"
puts abundantNumbers.length
a = 0
for b in abundantNumbers
temp = []
for c in abundantNumbers[a..abundantNumbers.length-1]

temp += [b+c]
if(b+c>goto)
break
end

end
sumNumbers = (sumNumbers+temp).uniq
a+=1
end

puts "done compiling abundant numbers list"
puts sumNumbers.length

total =0
for b in 1..goto
ina = 0
for c in sumNumbers
if(b==c)
ina = 1
break
end
end
if(ina==0)
total+=b
end

end

puts total