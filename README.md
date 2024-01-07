# CrossWordGen
A CLI cross word generator

# Running the code on Docker
```
docker build -t crossword .
docker run -it --rm crossword
```
# Running the Code Locally
```
javac *.java
java main.java
```


# Example 
```
Enter the number of words: 3
Enter word 1: car 
Enter word 2: apple
Enter word 3: jhon
  0     1     2     3     4     5     6     7     8     9     
0 _     _     _     _     _     _     _     _     _     _     

1 _     _     _     _     _     _     _     _     _     _     

2 _     _     _     _     _     _     _     _     _     _     

3 _     _     _     _     _     _     _     _     _     _     

4 _     _     _     _     _     _     _     _     _     _     

5 _     _     _     _     _     _     _     _     _     _     

6 _     _     _     _     _     _     _     _     _     _     

7 _     _     _     _     _     _     _     _     _     _     

8 _     _     _     _     _     _     _     _     _     _     

9 _     _     _     _     _     _     _     _     _     _

Placing word: apple
Enter x coordinate: 1
Enter y coordinate: 1
Enter direction (DOWN, RIGHT, DIAGONAL): diagonal
  0     1     2     3     4     5     6     7     8     9
0 _     _     _     _     _     _     _     _     _     _

1 _     a     _     _     _     _     _     _     _     _

2 _     _     p     _     _     _     _     _     _     _

3 _     _     _     p     _     _     _     _     _     _

4 _     _     _     _     l     _     _     _     _     _

5 _     _     _     _     _     e     _     _     _     _

6 _     _     _     _     _     _     _     _     _     _

7 _     _     _     _     _     _     _     _     _     _

8 _     _     _     _     _     _     _     _     _     _

9 _     _     _     _     _     _     _     _     _     _

Placing word: car
Enter x coordinate: 0
Enter y coordinate: 1
Enter direction (DOWN, RIGHT, DIAGONAL): right
  0     1     2     3     4     5     6     7     8     9
0 _     _     _     _     _     _     _     _     _     _

1 c     a     r     _     _     _     _     _     _     _

2 _     _     p     _     _     _     _     _     _     _

3 _     _     _     p     _     _     _     _     _     _

4 _     _     _     _     l     _     _     _     _     _

5 _     _     _     _     _     e     _     _     _     _

6 _     _     _     _     _     _     _     _     _     _

7 _     _     _     _     _     _     _     _     _     _

8 _     _     _     _     _     _     _     _     _     _

9 _     _     _     _     _     _     _     _     _     _

```
