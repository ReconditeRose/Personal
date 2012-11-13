def isSquare(i)
  return (Math.sqrt(i).round() == Math.sqrt(i))
end

def main
  endVal =1000
  max = 0
  maxHold = 0
  for i in 775..800
    if(isSquare(i))then
      next
    end
    x=1
    while(1)
      j=x*x*i+1
      if(isSquare(j))then
        j = Math.sqrt(j)
        puts (j.round(0).to_s+"^2-"+ i.round(0).to_s+"x"+x.round(0).to_s+"^2 = 1")
        if(j>max)then
          max = j
          maxHold = i
        end
        break
      end

      x+=1
    end

  end
  puts maxHold.to_s
end
main



