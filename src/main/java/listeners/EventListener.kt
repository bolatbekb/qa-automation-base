package listeners

import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import org.slf4j.LoggerFactory

open class EventListener : ITestListener {

    override fun onTestStart(result: ITestResult?) {
        println("Start test: ${result!!.name}")
    }

    override fun onFinish(context: ITestContext?) {
        println("Stop test: ${context!!.name}")
    }

    override fun onTestSkipped(result: ITestResult) {
        println("Skip test: ${result!!.name}")
    }

    override fun onTestSuccess(result: ITestResult) {
        println("Success test: ${result!!.name}")
    }

    override fun onTestFailure(result: ITestResult) {
        println("Failure test: ${result!!.name}")
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) {
    }

    override fun onStart(result: ITestContext?) {
    }
}