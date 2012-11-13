$num = 3
$den = 2

def iterate
  $num+=$den
  
  tempnum = $num
  $num = $den
  $den = tempnum
  
  $num+=$den
end

total = 0
for a in 1..1000
  puts $num
  puts $den
  if($num.to_s.length>$den.to_s.length)then
    total+=1
  end
  iterate
end
puts total