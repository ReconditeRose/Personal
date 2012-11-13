def sameDigits(z,x)
  a= z.to_s
  b= x.to_s
  if(a.length != b.length)then
    return false
  end
  for c in 0..9
    if(a.count(c.to_s) != b.count(c.to_s))then
      return false

    end
  end
  return true
end

def main
  a = 100
  b=1000
  while 1
    if(a>(b/6))then
      a=b
      b*=10
    end
    a+=1
    give = true
    for c in 2..6
      if(sameDigits(a,c*a)==false)then
        give = false
      end
    end
    if(give ==true)then
      return a
    end
  end
end

puts sameDigits(142857,142857*6)
puts main
