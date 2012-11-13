def combin(total,choose)
  b = 1
  for a in (total-choose+1)..total
    b*= a
  end
  for a in 1..choose
    b/=a
  end
  return b
end

def countCombs(number)
  total=0
  if(number%2==0)then
    temp = number/2
    if(combin(number,temp)>1000000)then
      temp-=1
      total+=1
    end
  else
    temp = (number-1)/2  
    if(combin(number,temp)>1000000)then
      temp-=1
      total+=2
    end
  end
  while combin(number,temp) >1000000
    temp-=1
    total+=2
  end
  return total
end

total = 0
for n in 23..100
  total+=countCombs(n)
end
puts total