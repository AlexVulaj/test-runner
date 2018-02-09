// Name of class to test
className = "Solution"
// Name of method to run
methodName = "sum"
// Names for each test, optional
testNames = []
// Input params for each test
inputs = [
        [1, 2, 2, 1],
        [1, 1],
        [1, 2, 3, 4, 5]
]
// Expected results for each test
expected = [6, 2, 15]
// Outputs individual test results if enabled
verbose = true

/*********************\
|* End Configuration *|
\*********************/
scriptStart = System.nanoTime()
failures = []
testClass = this.class.classLoader.loadClass(className)?.newInstance()
inputs.eachWithIndex { input, testNumber ->
    start = System.nanoTime()
    result = testClass."$methodName"(*input)
    end = System.nanoTime()
    success = result == expected[testNumber]

    testName = "${testNames[testNumber] ?: "Test $testNumber"}"
    if (!success) failures << testName
    if (verbose) println """$testName
result: ${success ? "Success" : "Failure - expected <${expected[testNumber]}> but was <$result>"}
time: ${(end - start) / 1E9} seconds
"""
}

println "${failures.isEmpty() ? "All tests passed" : "The following tests failed:\n${failures.join("\n")}"}\nScript took ${(System.nanoTime() - scriptStart) / 1000000000.0} seconds."