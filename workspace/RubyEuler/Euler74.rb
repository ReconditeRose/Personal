def charFactorial (string)
  sum = 0
  string.chars.each {|char| sum+=Factorial(char.to_i)}
  return sum

end

def Factorial (integer)
  product = 1
  while(integer >0)
    product *= integer
    integer-=1
  end
  return product
end

def Main
  totalCount = 1000000
  nonRepeat = Array.new(totalCount)
  compareTo = 1
  for i in 0..totalCount
    nonRepeat[i]=0
  end
  while(compareTo<totalCount)
    currentStreak = 1
    globalCompare = compareTo
    compareArray = Array.new()

    while(1)
      if(globalCompare<totalCount)
        if(nonRepeat[globalCompare] != 0)
          currentStreak-=1
          break
      end
  end
  
      compareArray = compareArray + [globalCompare]
      globalCompare = charFactorial(globalCompare.to_s)
      if(compareArray.count(globalCompare)==1)
        break
      end
      currentStreak+=1
    end
    if(globalCompare<totalCount)
      nonRepeat[compareTo] = currentStreak + nonRepeat[globalCompare]
    else
      nonRepeat[compareTo] = currentStreak
    end
    compareTo+=1
  end
puts nonRepeat.count(60)
end
Main()