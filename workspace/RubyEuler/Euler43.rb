def isAproxDig(string)
  returnNum = -1
  for i in 0..9
    compare = i.to_s
    if(string.count(compare)==0)then
      if(returnNum == -1)then
        returnNum = i
      else
        returnNum = -1
        break
      end
    elsif (string.count(compare)>1)then
      returnNum = -1
      break
    end
  end
  return returnNum
end



sum = 0
divisible = [2,3,5,7,11,13,17]
ma1 =0
ma2 = 0
ma3 = 0
while  ma1 <998
  ma1+=2
  while ma2 <993
    ma2+=7
    while ma3 <983
      ma3+=17
      max = "%03d%03d%03d" %  [ma1,ma2,ma3]

      temp = max.to_s
      clear = true
      for i in 0..6
        gray = temp[i].to_i*100+temp[i+1].to_i*10+temp[i+2].to_i
        if(gray == 0)then
          clear = false
          break
        end

        if(gray % divisible[i] != 0)then
          clear = false
          break
        end
      end
      if(clear == true) then
        a = isAproxDig(temp)
        if(a != -1)then
          puts a.to_s + temp
          sum += (a.to_s + temp).to_i
        end
      end

    end
    ma3= 0
  end
  ma2=0
end
puts sum