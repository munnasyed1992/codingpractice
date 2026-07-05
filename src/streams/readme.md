#Streams Methods:
-
- creation
- intermediate
- terminal

#Creation:
 - 
- of(),stream(),iterate(),generate()
- 
#Intermediate:(returns stream and chainable )
-
- filter(),map(),flatMap(),distinct(),sorted(),peek(),limit(),skip(),mapToInt(),mapToDouble(),mapToLong()

#Terminal: (triggers execution return results )
-
- forEach(),Collect(),count(),reduce(),findFirst(),findAny(),anyMatch(),allMatch(),noneMatch(),min(),max(),toList()
- 
- 
- 
- #####################################################

distinct() - uses equals and hashcode to compare objects so custom objects must implement 
Streams are lazy 
we can create int stream IntStream.of()
min() - gives us OPtinalInt we can use gatAsInt() 
Questions:
where intermediate operations store results or what is the flow of the streams