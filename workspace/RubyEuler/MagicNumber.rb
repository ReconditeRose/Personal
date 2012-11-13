load "DigitConvertToWord.rb"

def MagicString(a)
  newString = DigitToWord(a)
  set = 0
  totalLength = ""
  while set!=4
    nextString = DigitToWord(StripWhite(newString).length)
    set = StripWhite(newString).length
     totalLength+= newString + " is "+nextString + ","
       newString = nextString
  end
  totalLength+= " and 4 is the magic number."
  return totalLength
end

puts MagicString(50851821)