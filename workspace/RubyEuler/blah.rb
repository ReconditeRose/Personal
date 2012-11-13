
totalArray = []
aFile = File.new(File.new("My Documents/box.txt", "r"))
while(line = aFile.gets)
myarray = []
counter = 0
while(counter <59)
myarray+=[line[counter..counter+1].to_i]

counter +=3
end
totalArray+= [myarray]
end

currentMax=0

for i in (0...19)
for j in (0...19)

if(i+3<20)
temp = 1	
for mod in (0...4)
temp *= totalArray[i+mod][j]
end
if(temp > currentMax)
currentMax = temp
end
if(j+3<20)
temp = 1	
for mod in (0...4)
temp *= totalArray[i+mod][j+mod]
end
if(temp > currentMax)
currentMax = temp
end
end
if(j-3>0)
temp = 1	
for mod in (0...4)
temp *= totalArray[i+mod][j-mod]
end
if(temp > currentMax)
currentMax = temp
end
end

end

if(i-3>0)
temp = 1	
for mod in (0...4)
temp *= totalArray[i-mod][j]
end
if(temp > currentMax)
currentMax = temp
end

if(j+3<20)
temp = 1	
for mod in (0...4)
temp *= totalArray[i-mod][j+mod]
end
if(temp > currentMax)
currentMax = temp
end
end
if(j-3>0)
temp = 1	
for mod in (0...4)
temp *= totalArray[i-mod][j-mod]
end
if(temp > currentMax)
currentMax = temp
end
end


end
if(j+3<20)
temp = 1	
for mod in (0...4)
temp *= totalArray[i][j+mod]
end
if(temp > currentMax)
currentMax = temp
end


end
if(j-3>0)
temp = 1	
for mod in (0...4)
temp *= totalArray[i][j-mod]
end
if(temp > currentMax)
currentMax = temp
end

end

end
end
puts currentMax
