Schuyler Asplin

CSCD 467 Parellel & Cloud Computing

Many thanks to Professor Tian (who built the framework for this assignment)


From the THREADEDPRIMEHW2STUDENT directory:

Compiling: javac src/edu/ewu/ytian/prime/\*.java  
Running: java -cp ./bin/ edu.ewu.ytian.prime.MyPrimeTest 1 1 100

sample outputs:

java -cp ./bin/ edu.ewu.ytian.prime.MyPrimeTest 5 0 1000000
Time cost of serial code: 112 ms.
Time cost of parallel code: 35 ms.
The speedup ration is by using concurrent programming: 3.20.
Number prime found by serial code is: 78498
Number prime found by parallel code is 78498

java -cp ./bin/ edu.ewu.ytian.prime.MyPrimeTest 20 0 1000000
Time cost of serial code: 118 ms.
Time cost of parallel code: 32 ms.
The speedup ration is by using concurrent programming: 3.69.

java -cp ./bin/ edu.ewu.ytian.prime.MyPrimeTest 100 0 1000000
Time cost of serial code: 133 ms.
Time cost of parallel code: 32 ms.
The speedup ration is by using concurrent programming: 4.16.

java -cp ./bin/ edu.ewu.ytian.prime.MyPrimeTest 1000 0 1000000
Time cost of serial code: 107 ms.
Time cost of parallel code: 57 ms.
The speedup ration is by using concurrent programming: 1.88.
