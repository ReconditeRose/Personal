def isPalindrome(number)
number = number.to_s
isPalindrome=1
for a in 0..number.length-1
if(number[a] != number[number.length-1-a])
isPalindrome= 0
end
end
return isPalindrome
end

def reverseInt(number)
number =number.to_s
newNumber = number
b = number.length-1
for a in number.each_char
newNumber[b] = a
b -= 1
end 
return newNumber.to_i
end

def Lychel(a)
iterate = 0
palindrome = 0
while (iterate <50 && palindrome==0)
iterate+=1
a+= reverseInt(a)
palindrome = isPalindrome(a)
end
if(iterate<50)
return 0
else
return 1
end
end

total=0
for a in 0..10000
total+=Lychel(a)
end
puts total



