module Problem80
  a= Math.sqrt(2).to_s.chars
  sum = 0
 for b in 0..100
   sum+=a[b]
 end
 puts sum
end