start = 1
counter = 0
digits = 10
while (start < 1000)
temp = start%(10**digits)
c=1

for b in 0...start
c= c%(10**digits) *temp
end

counter+=c
start+=1
end

puts counter%(10**digits)