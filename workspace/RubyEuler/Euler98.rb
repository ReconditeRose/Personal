def sumArray(array)
b = 0
for a in array
b+=a
end
return b
end


def arrayPermutation(array)
total=1

while (array[0]>1)
if(array.length ==1)
total+=1
array = [array[0]-1,1]
else

max = sumArray(array)+1-array[0]
array[0]-=1

while (max > 0)
if(max > array[0])
array+=[array[0]]
total+=1
max-=array[0]
else
array+=[max]
total+=1
max=0
end

end
total+= arrayPermutation(array[1..array.length-1]);
end
end

return total
end

puts arrayPermutation([3])