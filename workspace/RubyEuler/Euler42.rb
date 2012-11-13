def wordValue(string)
  value =0
  for a in 0...(string.length)
    value += string.getbyte(a)-64

  end
  return value
end

triangles = []
for a in 1...200
  triangles += [a*(a+1)/2]
end

totalArray = []
myString = ""
aFile = File.new(File.new("words.txt", "r"))
while(a = aFile.getc)
  if(a=="\"")then
  elsif(a==",")then
    totalArray+=[myString.to_s]
    myString = ""
  else
    myString+=a
  end

end
b = 0
for a in totalArray
  if(triangles.count(wordValue(a))==1)then
    b+=1
  end
end


puts b