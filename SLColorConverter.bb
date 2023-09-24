Graphics 300,15,32,2

Cls
Print "Converting input to output..."
Flip

InputFile = ReadFile("input.txt")
OutputFile = WriteFile("output.txt")

While Not Eof(InputFile)

Local HexInput$ = Upper(ReadLine(InputFile))
	
	If HexInput$ <> "" Then
		
		WriteLine OutputFile,HexInput$
	
		Local X# = HexToInt( Left(HexInput$,2) )
		Local Y# = HexToInt( Mid(HexInput$,3,2) )
		Local Z# = HexToInt( Mid(HexInput$,5,2) )
		
		Local OutputString$ = "<"+Int(X#)+","+Int(Y#)+","+Int(Z#)+">"
		
		WriteLine OutputFile, OutputString
		
		X# = X# / 255
		Y# = Y# / 255
		Z# = Z# / 255
		
		OutputString$ = "<"+X#+","+Y#+","+Z#+">"
		
		WriteLine OutputFile, OutputString
		
	EndIf
	
Wend

CloseFile InputFile
CloseFile OutputFile

End

Function HexToInt(H$)
	integer=0
	For i=1 To Len(h$)
		hdigit=(Asc(Mid$(h$,i,1))-48) And $1f
		If hdigit>9 Then hdigit=hdigit-7
		integer=(integer Shl 4)+hdigit
	Next
	Return integer
End Function