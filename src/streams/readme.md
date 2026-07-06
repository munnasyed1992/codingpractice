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


Just print/do something?
└── forEach()

Just a number?
├── count()    → how many elements
├── min()      → smallest
└── max()      → largest

Just true or false?
├── anyMatch()  → at least one matches?
├── allMatch()  → all match?
└── noneMatch() → none match?

Need one element back?
├── findFirst() → first match
└── findAny()   → any match (parallel)

Combine into one value?
└── reduce()    → sum, product, longest etc

Need a collection back?
└── collect()
    ├── toList()
    ├── toSet()
    ├── toMap()
    ├── joining()
    ├── groupingBy()   → many groups
    └── partitioningBy() → two groups

    
Questions:
where intermediate operations store results or what is the flow of the streams


