// Name of class to test
className = ""
// Name of method to run
methodName = ""
// Names for each test, optional
testNames = []
// Input params for each test
inputs = []
// Expected results for each test
expected = []
// Outputs individual test results if enabled
verbose = false

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