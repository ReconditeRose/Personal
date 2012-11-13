def DigitToWord(input)

  arrayDigits = ["","one","two","three","four","five","six","seven","eight","nine"]
  arrayTens = ["ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"]
  arraySpecial= ["ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]
  arrayMod = ["","thousand","million","billion","trillion"]
  arrayModnum = 0
  combineName = ""
if(input ==0)then
  combineName = "zero"
end
  
  while input >0

    tempinput = input %1000
    input -= tempinput
    input /= 1000
    if(tempinput==0)then
      arrayModnum+=1
      next
    end
    tempinput = tempinput.to_s
    if(tempinput.length==2)
      digit1 = 0
      digit2 = tempinput[0].to_i
      digit3 = tempinput[1].to_i
    end

    if(tempinput.length==3)
      digit1 = tempinput[0].to_i
      digit2 = tempinput[1].to_i
      digit3 = tempinput[2].to_i
    end

    if(tempinput.length==1)
      digit1 = 0
      digit2 = 0
      digit3 = tempinput[0].to_i
    end

    nameString = ""

    if(digit1>0)
      if(digit2>0 || digit3>0)
        nameString += arrayDigits[digit1]+" hundred and "
      else
        nameString += arrayDigits[digit1]+" hundred"
      end
    end

    if(digit2>1)
      if(digit3>0)
        nameString += arrayTens[digit2-1] + " " +arrayDigits[digit3]
      else
        nameString += arrayTens[digit2-1]
      end
    end

    if(digit2==1)
      nameString += arraySpecial[digit3]
    end

    if(digit2==0)
      nameString += arrayDigits[digit3]
    end

    if(combineName=="")
      if(arrayModnum>0)
        combineName = nameString+" "+ arrayMod[arrayModnum]
        arrayModnum+=1
      else
        combineName = nameString
        arrayModnum+=1
      end
    else
      combineName = nameString+" "+ arrayMod[arrayModnum]+" " + combineName
      arrayModnum+=1
    end

  end
  return combineName
end

def StripWhite(string)
  newString = ""
  for i in 0..(string.length-1)
    if(string[i]!=" ")then
     newString += string[i]
  end
  end
  return newString
end