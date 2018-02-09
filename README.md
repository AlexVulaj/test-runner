# test-runner
A quick, configurable Groovy script for testing.

This script allows for quick testing and debugging of various Java puzzles and algorithms.  Works well for quick testing of different scenarios on sites like Codility, Project Euler, and others.
## Properties
At the top of the runner, you'll notice a few properties.
#### className
the name of the Java class your solution is written in as a `String`
#### methodName
the name of the method to test in `className` as a `String`
#### testNames
Optional property, gives a name to your input sets. These can be key-value indexed as such:

`testNames = [0: "First test", 4: "Last test"]`

or given just as an array:

`testNames = ["First test", "Second test", "Third test"]`

Any unnamed tests will default to "Test #", where "#" is the 0-indexed number of the test.
#### inputs
the list of input sets that will be used to test your solution.  Each entry in the list should be a list representing the full set of inputs for an individual call of your solution.  For example, given the method `public int foo(int n);`, a list of inputs may look like:
```
inputs = [
	[1],
	[2],
	[3],
	[4]
]
```
and given the method `public int foo(String str, int n);`, a list of inputs may look like:
```
inputs = [
        ["Foo", 3],
        ["Bar", 2],
        ["Apple", 6]
]
```
#### expected
the list of expected test results for each corresponding input
#### verbose
`boolean` value specifying whether or not details should be printed for each individual test case.  A sample verbose output may look like:
```
Test 0
result: Success
time: 0.052560233 seconds

Test 1
result: Failure - expected <1> but was <2>
time: 0.000082763 seconds

The following tests failed:
Test 1
Script took 0.134719333 seconds.
```
The identical tests run without verbose output would result in the following:
```
The following tests failed:
Test 1
Script took 0.072431091 seconds.
```
