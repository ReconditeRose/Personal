def GCD(a, b)
  if(b==0)then
    return a
  end
  return(GCD(b,a%b))
end

module Euler100
  puts "Hello World"
  puts (15.25).floor
 # init = 1000000000000
 init = 10
  continue = true
  while continue
    init+=1
    high = (init/Math.sqrt(2)).ceil
    
    high2 = (high-1)*(high)
    init2 = (init-1)*init
    
    if(init2/GCD(high2,init2)==2)then
      puts high.to_s+"/"+init.to_s
    end
  end
end